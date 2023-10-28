import java.awt.*;

public class HUD extends GameObject {


    public static int HEALTH = 360;
    private static int score = 0;
    private static int level = 1;
    private int greenValue = 255;

    public HUD(int x, int y, ID id, Handler handler) {
        super(x, y, id,handler);
    }

    public void tick() {
        if(HEALTH <=0) System.exit(1);
        if(HEALTH >360) HEALTH = 360;

        MainGame.clamp(greenValue,0,255);

        greenValue = HEALTH*2/3;



    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x-5,y-5,360+10,40);

        g.setColor(new Color(75,greenValue ,0)); //first value is red, second green and third is blue
        g.fillRect(x,y,HEALTH,30);


        g.setFont(new Font("Purist", Font.PLAIN, 23));
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score,15,70);
        g.drawString("level: " + level,15,90);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }


    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        HUD.score = score;
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        HUD.level = level;
    }
}
