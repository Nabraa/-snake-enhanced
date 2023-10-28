import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MainGame extends Canvas implements Runnable {

    private HUD hud;// adds the health bar to the game
    public static int WIDTH = 640;
    public static int HEIGHT=WIDTH/12*9;
    public boolean running = false;
    private Thread thread;
    private Handler handler;
    private Random r = new Random();
    private Spawn spawner;

    Image img = ImageIO.read(new File("images/dirt.jpg"));
    Image resultingImage = img.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

    public void run(){ // the run loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
           long now = System.nanoTime();
           delta += (now - lastTime) /ns;
           lastTime = now;
           while(delta>=1){
               tick();
               delta--;
           }
           if(running)
               render();
           frames++;
           if(System.currentTimeMillis() - timer >1000 ){
               timer += 1000;
               System.out.println("FPS: " + frames);
               frames=0;
           }

        }
        stop();
    }
    public void tick(){
        handler.tick();
        hud.tick();
        spawner.tick();
    } // it repeats a really fast. used often to check something etc.
    public synchronized void start(){
        thread = new Thread(this); // creates new thread to the game
        thread.start(); // starts the thread
        running = true; // the value "running" set to true. the game loop starts to render the game and do ticks.
    }
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static int clamp(int var, int min, int max){
        if(var >= max)
            return  var = max;
        else if(var<=min)
            return var = min;
        else return var;
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.create(); // creates a blank graphic object. this object has no color, or position
        //g.setColor(Color.BLACK); // sets color to the graphic object                                  These 3 lines create background
        g.drawImage(resultingImage,0,0,null);
        //g.fillRect(0,0,WIDTH,HEIGHT); // fills some area with previously set info
        handler.render(g); // renders every object. Doesn't make background and hud.


        hud.render(g); // renders hud

        g.dispose(); // stops graphic objects form usage ( the library says that, i think)
        bs.show(); // shows the objects

    }

    private MainGame() throws IOException {
        handler = new Handler(); // creates handler
        hud = new HUD(15,15,ID.HUD,handler);
        new Window("game", WIDTH, HEIGHT, this); // creates a window.
        this.addKeyListener(new KeyInput(handler)); // adds usage of the keys
        this.requestFocus(); // after creation of window, the focus is automatically set on window

        handler.addObject(new Player(60,60,ID.Player,handler));
        handler.addObject(new Point(160,60,ID.Point,handler));
        handler.addObject(new Point2(60,160,ID.Point2,handler));
        handler.addObject(new Enemy(60,160,ID.Enemy,handler));
        spawner = new Spawn(handler, hud);

    }

    public static void main(String[] args) throws IOException {
        new MainGame();
        }



}
