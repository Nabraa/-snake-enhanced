import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private Color color;
    private int width, height;
    private double life;

    public Trail(int x, int y, ID id, Handler handler, Color color, int width, int height, double life) {
        super(x, y, id, handler);
        this.color = color;
        this.width=width;
        this.height = height;
        this.life = life;
    }

    @Override
    public void tick() {
        if(alpha>life){ // checks if the single piece of a trial is still needed. every tick it lowers life of single piece of trial. if there is no time, it removes single piece of trial.
            alpha-=(life - 0.0001f);

        }else handler.removeObject(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));   // i dunno
        g.setColor(color);
        g.fillRect(x,y,width,height);
                g2d.setComposite(makeTransparent(1));
        

    }

    private AlphaComposite makeTransparent(float alpha){     // some big shit. just remember adding this
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type,alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
