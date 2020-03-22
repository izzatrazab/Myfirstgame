package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
//import java.util.Random;

public class SmartEnemy extends GameObject{

    private Handler handler;
    //private Random r =new Random();
    private GameObject player;
    private float SvelX;
    private float SvelY;


    public SmartEnemy(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
        
        for(int i = 0;i < handler.object.size();i++){
            if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);

        }
        SvelX = (float)3.0;
        SvelY = (float)3.0;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    public void tick(){
        x += SvelX;
        y += SvelY;
        
        
        float diffX = x - player.getX() - 2;
        float diffY = y - player.getY() - 2;
        float distance = (float)Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));

        SvelX = (float)((-1.0/distance)*diffX);
        SvelY = (float)((-1.0/distance)*diffY);

        collision();

        handler.addObject(new Trail(x, y, ID.Trail, Color.red, 16, 16, 0.09f, handler));
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
        g.fillRect((int)x, (int)y, 10, 10);
    }

}