import java.awt.*;
import java.util.Random;

public class Player extends GameObject{

     private Handler handler;
     private Random r = new Random();

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        velX = 5;
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,32,32);
    } // gives the bounds of the player(rectangle)

    private void collision(){
        for(int i = 0;i<handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.id == ID.Point) { // checks is the touched object,an enemy
                if(getBounds().intersects(tempObject.getBounds())){ // checks if the player touched the enemy
                    handler.removeObject(tempObject);
                    HUD.setScore(HUD.getScore() +1);

                    handler.addObject(new Point(r.nextInt(MainGame.WIDTH-30),r.nextInt(MainGame.HEIGHT-30),ID.Point,handler));
                }
            }
            if(tempObject.id == ID.Point2) { // checks is the touched object,an enemy
                if(getBounds().intersects(tempObject.getBounds())){ // checks if the player touched the enemy2
                    handler.removeObject(tempObject);
                    HUD.setScore(HUD.getScore() +2);
                    handler.addObject(new Point2(r.nextInt(MainGame.WIDTH-30),r.nextInt(MainGame.HEIGHT-30),ID.Point2,handler));
                }
            }
            if(tempObject.id==ID.Enemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH = HUD.HEALTH - 10;

                }
            }

        }

    }





    public void tick() {
        x+=velX;
        y+=velY;

        if(x >= MainGame.WIDTH) setX(0);        // these 4 lines create collision on the borders of the window
        else if(x <= 0) setX(MainGame.WIDTH);
        else if(y <= 0) setY(MainGame.HEIGHT);
        else if(y >= MainGame.HEIGHT) setY(0);

        collision();

        handler.addObject(new Trail(x,y,ID.Trail,handler,Color.WHITE,32,32, 0.02f)); // creates the trial behind the player

    }
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x,y,32,32);

    }
}
