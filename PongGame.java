/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pongGame;

/**
 *
 * @author dtrin
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
//why extend?
public class PongGame extends JPanel implements MouseMotionListener {
    //initializing variables
    static final int WINDOW_WIDTH = 640, WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userMouseY;
    private int userScore, pcScore;
    private int bounceCount;
    //constructor for PongGame
    public PongGame() {
        gameBall = new Ball(300, 200, 3, 3, 3, Color.WHITE, 10);
        userPaddle = new Paddle(10, 200, 75, 3, Color.WHITE);
        pcPaddle = new Paddle(610, 200, 75, 3, Color.WHITE);
        
        userMouseY = 0;
        userScore = 0; pcScore = 0;
        bounceCount = 0;
        //triggers mouse motion detection
        addMouseMotionListener(this);
    }
    //displaying objects
    @Override
    public void paintComponent(Graphics g) {
        //display background and set color to black
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        //update score
        g.setColor(Color.WHITE);
        //drawing ball
        gameBall.paint(g);
        //drawing paddles
        userPaddle.paint(g);
        pcPaddle.paint(g);
        //method takes in a String to print, and a location to print it at.
        g.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", 250, 20   );
    }
    //updating ball
    public void gameLogic(){
        //move the ball one frame
        gameBall.moveBall();
        //edge check/bounce
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
        //move the paddle towards where the mouse is
        userPaddle.paddleMovementY(userMouseY);
        //move the PC paddle towards the ball y position
        pcPaddle.paddleMovementY(gameBall.getY());
        // check collision with userPaddle
        if (userPaddle.checkCollision(gameBall)) {
            gameBall.reverseX();
        }
        // check collision with pcPaddle
        if (pcPaddle.checkCollision(gameBall)) {
            //reverse ball
            gameBall.reverseX();
            //increment bounceCount
            bounceCount++;
        }
        //increase in speed after 5 bounces
        if (bounceCount == 5) {
            //reset bounceCount
            bounceCount = 0;
            // call increase speed 
            gameBall.increaseSpeed();
        } 
        //update score
        if(gameBall.getX() < 0){
            //player has lost
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            //pc has lost
            userScore++;
            reset();
        }
    }        
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //set user mouse to mouse y position
        userMouseY = e.getY();
    }
    //restarts game
    public void reset(){
        //pause for a second
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
	//reset ball
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setCx(3);
        gameBall.setCy(3);
        gameBall.setSpeed(3);
        bounceCount = 0;
    }
}
