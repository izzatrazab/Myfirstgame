package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import app.GamePertama.STATE;

import java.awt.Font;

public class Menu extends MouseAdapter{

    private GamePertama game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    
    public Menu(GamePertama game, Handler handler,HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
        for(int i=0;i<10;i++){
            handler.addObject(new MenuParticle(r.nextInt(GamePertama.WIDTH/2-32),r.nextInt(GamePertama.HEIGHT/2-32),ID.MenuParticle, handler));
        }
    }


    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        //in menu
        if(game.gameState == STATE.Menu){
            //play button
            if(mouseOver(mx, my,210, 130, 200, 64)){
                game.gameState = STATE.Select;
            }
            

            //help button
            if(mouseOver(mx, my,210, 230, 200, 64)){
                game.gameState = STATE.Help;
            }
            
            //quit button
            if(mouseOver(mx, my,210, 330, 200, 64)){
                System.exit(1);
            }
        }else
        
        //in difficulty
        if(game.gameState == STATE.Select){
            //normal button
            
            if(mouseOver(mx, my,210, 130, 200, 64)){
                
                game.diff = 0;
                game.gameState = STATE.Game;
                handler.clearEnemies();
                handler.addObject(new Player(GamePertama.WIDTH/2-32,GamePertama.HEIGHT/2-32,ID.Player, handler));
            }
            

            //hard button
            if(mouseOver(mx, my,210, 230, 200, 64)){
                
                game.diff = 1;
                game.gameState = STATE.Game;
                handler.clearEnemies();
                handler.addObject(new Player(GamePertama.WIDTH/2-32,GamePertama.HEIGHT/2-32,ID.Player, handler));
            }
            
            //back button
            if(mouseOver(mx, my,500, 387, 74, 25)){
            game.gameState = STATE.Menu;
            }
        }// game over state
        else if(game.gameState == STATE.End){
            //handler.clearAll();
            
            //menu button after death
            if(mouseOver(mx, my,500, 387, 74, 25)){
                Sound.gameMusic.loop();
                game.gameState = STATE.Menu;
                hud.setHealth(100);
                hud.setScore(0);
                hud.setLevel(1);
                for(int i=0;i<10;i++){
                    handler.addObject(new MenuParticle(r.nextInt(GamePertama.WIDTH/2-32),r.nextInt(GamePertama.HEIGHT/2-32),ID.MenuParticle, handler));
                }
                
            }
        }else if(game.gameState == STATE.Help){
            //back button (go to menu)
            if(mouseOver(mx, my,500, 387, 74, 25)){
            game.gameState = STATE.Menu;
            }
        }else if(game.gameState == STATE.Win){
            //handler.clearAll();
            
            //menu button after death
            if(mouseOver(mx, my,500, 387, 74, 25)){
                for(int i=0;i<10;i++){
                handler.addObject(new MenuParticle(r.nextInt(GamePertama.WIDTH/2-32),r.nextInt(GamePertama.HEIGHT/2-32),ID.MenuParticle, handler));
                }
                game.gameState = STATE.Menu;
                hud.setHealth(100);
                hud.setScore(0);
                hud.setLevel(1);
            }
        }
       

        
        
    }
   
    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my,int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }
    public void tick(){
       
    }

    public void render(Graphics g){
        
        
        if(game.gameState == STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
    
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("MENU", 240,70);
    
            g.setFont(fnt2);
            
            g.drawRect(220, 130, 200, 64);
            g.drawString("Play", 260,170);
    
            
            g.drawRect(220, 230, 200, 64);
            g.drawString("Help", 260,270);
    
            
            g.drawRect(220, 330, 200, 64);
            g.drawString("Quit", 260,370);

            
        }else if(game.gameState == STATE.Help){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font ("consolas",1,15);
    
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("HELP", 240,70);
            g.setFont(fnt3);
            g.drawString("Use W,S,D,A keys to move the player around, and P to pause", 100, 180);
            g.drawString("You are required to avoid all enemies in each level.", 100, 195);
            g.drawString("This game is created as a practice for improving my", 100, 230);
            g.drawString("java skills. I followed java tutorial from", 100, 245);
            g.drawString("RealTutsGML and make some changes here and there, ", 100, 260);
            g.drawString("hope you enjoy playing this game.", 100, 275);
            
            g.setFont(fnt2);
            g.drawString("Back", 500,410);
        }else if(game.gameState == STATE.End){
            
            
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font ("consolas",1,15);
    
            g.setFont(fnt);
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 170,190);
            g.setFont(fnt3);
            g.drawString("SCORE: "+hud.getScore(),180,240);
            g.drawString("LEVEL: "+hud.getLevel(),180,260);
            g.setColor(Color.WHITE);
            g.setFont(fnt2);
            g.drawString("Menu", 500,410);
            
        }else if(game.gameState == STATE.Select){
            
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
    
            g.setFont(fnt);
            g.setColor(Color.WHITE);
            g.drawString("DIFFICULTY", 180,70);
    
            g.setFont(fnt2);
            
            g.drawRect(220, 130, 200, 64);
            g.drawString("nOrMaL", 260,170);
            
            g.drawRect(220, 230, 200, 64);
            g.drawString("HaRd", 260,270);
    
            g.setFont(fnt2);
            g.drawString("Back", 500,410);
            
        }else if(game.gameState == STATE.Win){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font ("consolas",1,15);
    
            g.setFont(fnt);
            g.setColor(Color.YELLOW);
            g.drawString("WINNER", 170,150);
            g.drawString("CONGRATULATION", 110,200);
            g.setFont(fnt3);
            g.setColor(Color.CYAN);
            g.drawString("SCORE: "+hud.getScore(),180,260);
            g.drawString("LEVEL: "+hud.getLevel(),180,280);
            g.setColor(Color.WHITE);
            g.setFont(fnt2);
            g.drawString("Menu", 500,410);
        }
        
    }
    
}