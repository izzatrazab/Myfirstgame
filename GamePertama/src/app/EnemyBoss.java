package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

    private Handler handler;
    private Random r =new Random();
    private int timer = 80;
    private int timer2 = 50;

    public EnemyBoss(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;
        velX=0;
        velY=2;

    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
        
    }

    public void tick(){
        x += velX;
        y += velY;

        if(timer <=0 ) velY = 0;
        else timer--;

        if(timer <=0) timer2--;
        if(timer2 <= 0){
            if(velX == 0) velX =2;

            if(velX>0){
                velX+=0.01f; 
            }else if(velX < 0){
                velX-=0.01f;
            }
            velX=GamePertama.clamp(velX, -10, 10);
            int spawn = r.nextInt(10);
            if(spawn ==0) handler.addObject(new EnemyBossBullet((int)x+36,(int)y+36,ID.EnemyBossBullet,handler));
        }
        //if(y<=0||y>=FirstGame.HEIGHT - 58) velY *= -1;
        if(x<=0||x>=GamePertama.WIDTH -81) velX *= -1;

        //handler.addObject(new Trail(x, y, ID.Trail, Color.DARK_GRAY, 64, 64, 0.09f, handler));

        collision();
    }

    private void collision(){
        for (int i = 0; i<handler.object.size();i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 4;
                
                }
                
            }
            
        }
    }

    public void render (Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect((int)x,(int) y, 64, 64);
    }
}