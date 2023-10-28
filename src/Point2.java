import java.awt.*;

public class Point2 extends GameObject {

    public Point2(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
        velX = -4;
        velY = -4;
    }

    public Rectangle getBounds(){ // gets the bounds of the enemy
        return new Rectangle(x,y,32,32);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if(y > MainGame.HEIGHT-60 || y< 0){
//            velX *= -1;
            velY *= -1;
        }
        if(x > MainGame.WIDTH-60 || x< 0){
            velX *= -1;
//            velY *= -1;
        }

        handler.addObject(new Trail(x,y,ID.Trail, handler, Color.BLUE, 32,32, 0.1f ));

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,32,32);
    }
}
