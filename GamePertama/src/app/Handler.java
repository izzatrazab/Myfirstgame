package app;

import java.util.LinkedList;
import java.awt.Graphics;

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for(int i = 0;i<object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();

        }
    }

    public void render(Graphics g){
        for(int i = 0;i<object.size(); i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);

        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

    public void clearEnemies(){
        for(int i = 0;i<object.size(); i++){
            GameObject tempObject = object.get(i);

            if(tempObject.getId() != ID.Player){
                object.remove(i);
                i--;
            } 
            
        }
    }
    public void clearAll(){
        while(0<object.size())
            object.remove(0);
    }
}