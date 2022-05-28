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
public class Paddle extends GameElement implements Updateable, Renderable{
    
    private double velocity;
    private String direction;
    
    public Paddle(){
        super();
        direction = "NEUTRAL	";
    }
    
    public Paddle(double wid, double hei, double xVal, double yVal, double vel){
        super(wid, hei, xVal, yVal);
        velocity = vel;
        direction = "NEUTRAL	";
    }
    public void setVel(double vel){
        velocity = vel;
    }
    
    public double getVel(){
        return velocity;
    }
    
    public void setDirection(String dir){
        direction = dir;
    }
    
    public String getDirection(){
        return direction;
    }
    @Override
    public void onCollision(GameElement ge) {
        //nothing
    }

    @Override
    public void checkCollision(GameElement ge) { 
        double xOverlap = Math.min(this.getX() + this.getWidth() - ge.getX(), ge.getX() + ge.getWidth()-this.getX());
        double yOverlap = Math.min(this.getY() + this.getHeight() - ge.getY(), ge.getY() + ge.getHeight() - this.getY());
        if(xOverlap>0 && yOverlap>0){
            onCollision(ge);
        }
        
    }

    @Override
    public void update() {
        //move paddle
        //draw(canvas, Color.WHITE);
        if (direction.equals("LEFT")) {
            super.setX(super.getX() + -velocity);
        } else if (direction.equals("RIGHT")) {
            super.setX(super.getX() + velocity);
        }
    }

    @Override
    public void draw(Canvas canvas, Color col) {
        //redraw the paddle on the screen
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        graphics.setFill(col);
        graphics.fillRect(getX(), getY(), getWidth(), getHeight()); 
    }
    
}
