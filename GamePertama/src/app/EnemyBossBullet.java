package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.util.Random;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

    private Handler handler;
    private Random r =new Random();

    public EnemyBossBullet(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;

        velX= (r.nextInt(10)-5);
        velY= 3;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
        
    }

    public void tick(){
        x += velX;
        y += velY;

        
        if(y>=GamePertama.HEIGHT) handler.removeObject(this) ;
        //if(x<=0||x>=FirstGame.WIDTH -81) velX *= -1;

        collision();
        handler.addObject(new Trail(x, y, ID.Trail, Color.DARK_GRAY, 16, 16, 0.09f, handler));
    }

    private void collision(){
        for (int i = 0; i<handler.object.size();i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 6;
                    handler.removeObject(this);
                }
                
            }
            
        }
    }
    public void render (Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect((int)x,(int) y, 16, 16);
    }
}