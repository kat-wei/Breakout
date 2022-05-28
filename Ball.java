/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.util.Set;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author 18_kat_18
 */
public class Ball extends GameElement implements Updateable, Renderable{
    private double xSpeed, ySpeed;
    
    public Ball(){
        super();
    }
    
    public Ball(double wid, double hei, double xVal, double yVal, double xSpd, double ySpd){
        super(wid, hei, xVal, yVal);
        xSpeed = xSpd;
        ySpeed = ySpd;
    }
    
    public void setXSpeed(double xSpd){
        xSpeed = xSpd;
    }
    
    public void setYSpeed(double ySpd){
        ySpeed = ySpd;
    }
    
    public double getXSpeed(){
        return xSpeed;
    }
    
    public double getYSpeed(){
        return ySpeed;
    }
    
    @Override
    public void onCollision(GameElement ge) {
        //bounce off other objects
        if(ge.getY()<=0){
            this.setYSpeed(-ySpeed);
        }      
    }

    @Override
  
    public void checkCollision(GameElement ge) {
        double xOverlap = Math.min(this.getX() + this.getWidth() - ge.getX(), ge.getX() + ge.getWidth()-this.getX());
        double yOverlap = Math.min(this.getY() + this.getHeight() - ge.getY(), ge.getY() + ge.getHeight() - this.getY());

        if(xOverlap>0 && yOverlap>0){
      
            if(yOverlap > xOverlap){
                this.setXSpeed(-this.getXSpeed());
            }else{
                this.setYSpeed(-this.getYSpeed());
            }
        }        
             
    }

    @Override
    public void update() {
        super.setX(super.getX() + xSpeed);
        super.setY(super.getY() + ySpeed);
		//update the ball location


    }

    @Override
    public void draw(Canvas canvas, Color col) {
        //uncomment after you write the set and get methods
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(col);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight()); 
    }

    

}
