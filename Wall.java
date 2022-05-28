/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

/**
 *
 * @author 18_kat_18
 */
public class Wall extends GameElement{
    
    public Wall(){
        super();
    }
    
    public Wall(double wid, double hei, double xVal, double yVal){
        super(wid, hei, xVal, yVal);
    }

    @Override
    public void onCollision(GameElement ge) {
    }

    @Override
    public void checkCollision(GameElement ge) {
        double xOverlap = Math.min(this.getX() + this.getWidth() - ge.getX(), ge.getX() + ge.getWidth()-this.getX());
        double yOverlap = Math.min(this.getY() + this.getHeight() - ge.getY(), ge.getY() + ge.getHeight() - this.getY());
        if(xOverlap>0 && yOverlap>0){
            onCollision(ge);
        }
        
        
        
    }
        
    
}
