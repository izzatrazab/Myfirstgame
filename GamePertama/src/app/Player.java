package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{

    Random r = new Random();
    Handler handler;
    public Player(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 20, 20);
    }

    
    public void tick(){
        y+=velY;
        x+=velX;
       
        
        x = GamePertama.clamp(x,0,GamePertama.WIDTH-34);
        y = GamePertama.clamp(y,0,GamePertama.HEIGHT-58);

        //collision();
        handler.addObject(new OvalTrail(x, y, ID.Trail, Color.cyan, 20, 20, 0.09f, handler));
    }

    /*private void collision(){
        for (int i = 0; i<handler.object.size();i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.BasicEnemy){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 1;
                }
                //handler.removeObject(BasicEnemy(getX(), getY(), getId(),BasicEnemy.handler);
            }
            if(tempObject.getId() == ID.FastEnemy){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;
                }
            }
            if(tempObject.getId() == ID.SmartEnemy){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 1;
                }
            }
            if(tempObject.getId() == ID.EnemyBoss){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 3;
                }
            }
        }
    }*/

    public void render(Graphics g) {
        // TODO Auto-generated method stub

    }

    

}