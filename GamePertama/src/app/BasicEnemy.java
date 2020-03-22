package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject{

    private Handler handler;
    private Random r =new Random();


    public BasicEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);

        this.handler = handler;
        velX = r.nextInt(7)-2;
        velY = r.nextInt(7)-2;
        while(velX==0&&velY==0){
        velX = r.nextInt(7)-2;
        velY = r.nextInt(7)-2;
        }
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
        
    }

    public void tick(){
        x += velX;
        y += velY;

        if(y<=0||y>=GamePertama.HEIGHT - 58) velY *= -1;
        if(x<=0||x>=GamePertama.WIDTH -32) velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, Color.YELLOW, 16, 16, 0.09f, handler));
        collision();
        
    }
    private void collision(){
        for (int i = 0; i<handler.object.size();i++){

            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player){

                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 5;
                    handler.removeObject(this);
                }
                
            }
            
        }
    }
    public void render (Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect((int)x,(int) y, 10, 10);
    }
}