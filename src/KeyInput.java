import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.id == ID.Player) {
                if (KeyEvent.VK_W == key){
                    if(tempObject.velY != 5){
                    tempObject.setVelY(-5);
                    tempObject.setVelX(0);}}
                if (KeyEvent.VK_S == key){
                    if(tempObject.velY != -5){
                    tempObject.setVelY(5);
                    tempObject.setVelX(0);}}
                if (KeyEvent.VK_A == key){
                    if(tempObject.velX != 5){
                    tempObject.setVelX(-5);
                    tempObject.setVelY(0);}}
                if (KeyEvent.VK_D == key){
                    if(tempObject.velX != -5){
                    tempObject.setVelX(5);
                    tempObject.setVelY(0);}}
            }
            if(key == KeyEvent.VK_ESCAPE) System.exit(1);


        }
    }

//    public void keyReleased(KeyEvent e) {
//        int key = e.getKeyCode();
//        for (int i = 0; i < handler.object.size(); i++) {
//            GameObject tempObject = handler.object.get(i);
//           if (tempObject.id == ID.Player) {
//                if (KeyEvent.VK_W == key) tempObject.setVelY(0);
//                if (KeyEvent.VK_S == key) tempObject.setVelY(0);
//                if (KeyEvent.VK_A == key) tempObject.setVelX(0);
//                if (KeyEvent.VK_D == key) tempObject.setVelX(0);
//
//            }
//
//
//    }
//    }
}

