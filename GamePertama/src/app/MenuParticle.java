package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;
    private Random r = new Random();
    private int red = r.nextInt(255);
    private int green = r.nextInt(255);
    private int blue = r.nextInt(255);
    private Color col;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = r.nextInt(10)-2;
        velY = r.nextInt(10)-2;
        while((velX<=1&&velX>=-1)||(velY<=1&&velY>=-1)){
        velX = r.nextInt(10)-2;
        velY = r.nextInt(10)-2;
        }

        col = new Color(red, green, blue);

    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= GamePertama.HEIGHT - 58)
            velY *= -1;
        if (x <= 0 || x >= GamePertama.WIDTH - 32)
            velX *= -1;

        handler.addObject(new OvalTrail(x, y, ID.OvalTrail, col, 20, 20, 0.09f, handler));
    }
    public void render(Graphics g) {
        g.setColor(col);
        g.fillOval((int) x, (int) y, 20, 20);
        
    }
}