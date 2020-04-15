package app;

import java.util.Random;
import app.GamePertama.STATE;

public class Spawn{

    private Handler handler;
    private HUD hud;
    private GamePertama game;
    //private int delayer=0; not use for now
    private java.util.Random r = new Random();
    //start num of enemy
    


    static int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud, GamePertama game){
        this.handler = handler;
        this.hud = hud;
        this.game=game;
        
    }

    public void tick(){
        scoreKeep++;
        //normal difficulty

        
        if(scoreKeep==1){
            if(game.diff == 0){
            if(scoreKeep==1&&(hud.getLevel()==1)){
                for(int o = 0;o<5;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==2)){
                for(int o = 0;o<10;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<5;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==3)){
                for(int o = 0;o<10;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<10;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==4)){
                for(int o = 0;o<10;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
                for(int o = 0;o<5;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==5)){
                for(int o = 0;o<5;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<10;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
                for(int o = 0;o<5;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==6)){
                for(int o = 0;o<10;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
                for(int o = 0;o<10;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==7)){
                handler.addObject(new EnemyBoss(GamePertama.WIDTH/2-46,-150,ID.EnemyBoss, handler));
       
            }

        }
        //hard difficulty
        else if(game.diff==1){
            if(scoreKeep==1&&(hud.getLevel()==1)){
                for(int o = 0;o<10;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<5;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
            }else if(scoreKeep==1&&(hud.getLevel()==2)){
                for(int o = 0;o<5;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<10;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==3)){
                for(int o = 0;o<5;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<15;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==4)){
                for(int o = 0;o<15;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
                for(int o = 0;o<5;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==5)){
                for(int o = 0;o<5;o++)
                handler.addObject(new BasicEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.BasicEnemy,handler));
        
                for(int o = 0;o<15;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
                for(int o = 0;o<5;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==6)){
                for(int o = 0;o<15;o++)
                handler.addObject(new FastEnemy (r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID. FastEnemy,handler));
            
                for(int o = 0;o<10;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
            }else if(scoreKeep==1&&(hud.getLevel()==7)){
                handler.addObject(new EnemyBoss(GamePertama.WIDTH/2-46,-150,ID.EnemyBoss, handler));
                for(int o = 0;o<10;o++)
                handler.addObject(new SmartEnemy(r.nextInt(GamePertama.WIDTH-35),r.nextInt(GamePertama.HEIGHT-60),ID.SmartEnemy,handler));
                
            }
        }
        
        }else if(scoreKeep==700&&hud.getLevel()!=7)handler.clearEnemies();
        
        
        if(scoreKeep >= 1200&&hud.getLevel()==7){
            game.gameState=STATE.Win;
            handler.clearAll();
        }else if(scoreKeep >= 750&&hud.getLevel()!=7){
            scoreKeep = 0;
            //increase level
            hud.setLevel(hud.getLevel()+1);

            //each level health increase by 10
            if(hud.getHealth()+10>=100){
                hud.setHealth(100);
            }else {
                hud.setHealth(hud.getHealth()+10);
                hud.setScore(hud.getScore()+hud.getHealth());
            }
        }
        if(hud.getHealth()<=0){
            scoreKeep=0;
        }
    }
    
    
}