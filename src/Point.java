import java.awt.*;

public class Point extends GameObject{
    public Point(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
    }

    public Rectangle getBounds(){ // gets the bounds of the enemy
        return new Rectangle(x,y,32,32);
    }

    @Override
    public void tick() {}

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x,y,32,32);
    }
}
