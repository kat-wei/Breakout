/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author 18_kat_18
 */
public class Block extends GameElement implements Renderable{
    
    public Block(){
        super();
    }
    
    public Block(double wid, double hei, double xVal, double yVal){
        super(wid, hei, xVal, yVal);
    }

    
    public void destroy(){
        this.setHeight(0);
        this.setWidth(0);
        this.setX(0);
        this.setY(0);
    }
    
    @Override
    public void onCollision(GameElement ge) {
        destroy();
    }
        
    
    
    @Override
    public void checkCollision(GameElement ge) {
      //X overlap
        double xOverlap = Math.min(this.getX() + this.getWidth() - ge.getX(), ge.getX() + ge.getWidth()-this.getX());
        double yOverlap = Math.min(this.getY() + this.getHeight() - ge.getY(), ge.getY() + ge.getHeight() - this.getY());
        if(xOverlap>0 && yOverlap>0){
            onCollision(ge);
        }
        
    }
    
    @Override
    public void draw(Canvas canvas, Color col) {
        //uncomment after you write the set and get methods
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(col);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight()); 
    }

    
}
