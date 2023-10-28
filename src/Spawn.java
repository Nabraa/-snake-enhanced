import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep = hud.getScore();

        if(scoreKeep>=50 && scoreKeep <100 && hud.getLevel()==1) {
            hud.setLevel(2);
            hud.setScore(0);

            HUD.HEALTH = HUD.HEALTH + 120;
            handler.addObject(new Enemy(r.nextInt(MainGame.WIDTH),r.nextInt(MainGame.HEIGHT),ID.Enemy, handler));
        }
        if(hud.getLevel() == 2 && scoreKeep >=100 && scoreKeep <200){
            hud.setLevel(3);
            hud.setScore(0);

            HUD.HEALTH = HUD.HEALTH + 120;
        }

    }

}
