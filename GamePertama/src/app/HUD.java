package app;

import java.awt.Color;
import java.awt.Graphics;


public class HUD{

    public static int HEALTH = 100;
    private int greenValue = 255;
    private int delay = 0;
    private int score = 0;
    public static int level = 1;
    public void tick(){

        HEALTH = (int)GamePertama.clamp((float)HEALTH,0,100);
        greenValue = (int)GamePertama.clamp((float)greenValue, 0, 255);

        greenValue = HEALTH*2;
        
        delay++;
        if(delay == 100){
            score+=5;
            delay = 0;
        }
        
    }

    public void render(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect( 15, 15, 200, 32);
        g.setColor(new Color(75, greenValue,0));
        g.fillRect(15,15,HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15, 14, 200, 32);

        g.drawString("Score: "+ score, 15, 64);
        g.drawString("Level : "+ level, 15, 80);
        
    }
    public void setScore(int score){
        this.score = score;

    }
    public int getScore(){
        return score;
    }
     public void setLevel(int level){
         HUD.level = level;
     }

     public int getLevel(){
         return HUD.level;
     }

    public void setHealth(int HEALTH){
        HUD.HEALTH=HEALTH;
    }

    public int getHealth(){
        return HUD.HEALTH;
    }
}
