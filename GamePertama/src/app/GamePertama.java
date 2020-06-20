
package app;

//import java.util.Random;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;



public class GamePertama extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 3987536256371505872L;

    public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
   
    private Thread thread;
    private boolean running = false;
    public static boolean paused = false;
    
    //0 for normal 1 for hard
    public int diff;

    //private Random r;
    private Handler handler ;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public enum STATE{
        Menu,
        Select,
        Help,
        Game,
        Win,
        End
    };

    public STATE gameState = STATE.Menu;

    public GamePertama(){
        
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this,handler,hud);
        this.addKeyListener(new KeyInput(handler,this));
        this.addMouseListener(menu);
        
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
        
        
        spawner = new Spawn(handler,hud,this);
        Sound.gameMusic.loop();
        //r = new Random();
        
        
        //handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player, handler));
        
        //handler.addObject(new EnemyBoss(WIDTH/2-46,-120,ID.EnemyBoss, handler));
       
        
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        //int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            //frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                //frames = 0;
            }
        }
        stop();
    }

    private void tick(){
        
        if(gameState == STATE.Game){
            
            if(paused == false){
                Sound.gameMusic.unpause();
                hud.tick();
                spawner.tick();
                handler.tick();
            
                
                if(HUD.HEALTH <=0){

                    gameState = STATE.End;
                    Sound.gameMusic.stop();
                    Sound.dieSound.play();
                    
                    Spawn.scoreKeep=0;
                    handler.clearAll();
                    
                }
            }
            
        }else if(gameState == STATE.Menu||gameState == STATE.End||gameState == STATE.Select||gameState==STATE.Help||gameState==STATE.Win){
            menu.tick();
           handler.tick();

        }
        //hud.tick();
        //spawner.tick();
    }

    private void render(){
        
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH, HEIGHT);

        handler.render(g);

        if(paused){
            Sound.gameMusic.pause();
            g.setColor(Color.white);
            g.drawString("PAUSED", 100,100);
        }
        if(gameState == STATE.Game){
            hud.render(g);
        }else if(gameState == STATE.Menu || gameState == STATE.Help|| gameState == STATE.End||gameState==STATE.Select||gameState==STATE.Win){
            menu.render(g);
        }
        hud.render(g);

        g.dispose();
        bs.show();
        
    }

    public static float clamp(float var, float min, float max){
        if (var>=max)
            return var = max;
        else if (var<=min)
            return var = min;
        else 
            return var;
    }

    public static void main(String[] args){
        new GamePertama();
    }
   
}