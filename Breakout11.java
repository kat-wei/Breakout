/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import javafx.scene.canvas.Canvas;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 *
 */
public class Breakout11 extends Application {

    /**
     * @param args the command line arguments
     */
    private static final int WIDTH = 900;
    private static final int HEIGHT = 600;
    private static Canvas canvas;

    //DECLARE a static GameState object here (used in the timer)
    RedrawTimer timer = new RedrawTimer();
    GameState tester;
     
    @Override
    public void start(Stage primaryStage) throws Exception {
       
        StackPane root = new StackPane();
          
        canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);
        //instantiate your GameState object
        tester = new GameState();
        
        //create walls, ball, paddle, and blocks
        Wall wall = new Wall(WIDTH, 1, 0, 0);
        Wall wall2 = new Wall(1, HEIGHT, 0,0);
        Wall wall3 = new Wall(1, HEIGHT, WIDTH-1,0);
        
        Ball ball = new Ball(15, 15, 500, 300, -3, 3);
        Paddle paddle = new Paddle(60, 10, 450, 500, 3);
        Block block = new Block(50, 10, 500, 300);
        
        for(int y = 0; y<5; y++){
            for(int x = 0; x<15; x++){
            block = new Block(50 , 10, x * 60, 30 * y);
            tester.add(block);
            }
        }
                
        //add the game elements (walls, ball, paddle, and blocks) to the GameState object 
        tester.add(paddle);       
        tester.add(wall);
        tester.add(wall2);
        tester.add(wall3);
        tester.add(ball);
        
        //tester.add(block);
        
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        primaryStage.setTitle("Breakout");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        timer.start();
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT) {
                     paddle.setDirection("RIGHT");
                }
                if (event.getCode() == KeyCode.LEFT) {
                    paddle.setDirection("LEFT");
                }
                
            }

        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.RIGHT) {
                     paddle.setDirection("NEUTRAL");
                }
                if (event.getCode() == KeyCode.LEFT) {
                    paddle.setDirection("NEUTRAL");
                }
                
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class RedrawTimer extends AnimationTimer {

        public void handle(long now) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, WIDTH, HEIGHT);
            
            //update, draw and collide all of the Game Elements in the GameState object              
            tester.UpdateAll(canvas);
            tester.DrawAll(canvas);            
            tester.CollideAll();
           
           //tester.UpdateAll();
        }
    }

}
