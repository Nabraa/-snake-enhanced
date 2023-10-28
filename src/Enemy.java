import java.awt.*;

public class Enemy extends GameObject{

    public Enemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);

        velX = 7;
        velY = 7;
    }

    @Override
    public void tick() {
        x+=velX;
        y+=velY;

        if(y > MainGame.HEIGHT-60 || y< 0){
//            velX *= -1;
            velY *= -1;
        }
        if(x > MainGame.WIDTH-60 || x< 0){
            velX *= -1;
//            velY *= -1;
        }

        handler.addObject(new Trail(x,y,ID.Trail, handler, Color.RED, 16,16, 0.1f ));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x,y,16,16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,16,16);
    }
}
