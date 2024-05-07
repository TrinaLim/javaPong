/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pongGame;

/**
 *
 * @author dtrin
 */
import java.awt.*;
public class Paddle {
    // initializing instance variables 
    private int height, x, y, speed;
    private Color color;
    static final int PADDLE_WIDTH = 15;
    //constructor 
    public Paddle(int x, int y, int height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }
    //display rectangle paddle 
    public void paint(Graphics g){
    g.setColor(color);
    //draw rectangle
    g.fillRect(x, y, PADDLE_WIDTH, height);
    }
    //paddle movement in y direction
    public void paddleMovementY(int moveToY) {
        //coordinates of paddle at the center
        int centerY = y + height / 2;
        //determine if we need to move more than the speed away from where we are now
        if(Math.abs(centerY - moveToY) > speed){
            //if the center of the paddle is down
            if(centerY > moveToY){
                //move the paddle up by the speed
                y -= speed;
            }
            //if the center of the paddle is up
            if(centerY < moveToY){
                //move the paddle down by speed
                y += speed;
            }
        }
    }
    public boolean checkCollision(Ball b){
        int rightX = x + PADDLE_WIDTH;
        int bottomY = y + height;
         //check if the Ball is between the x values
        if(b.getX() > (x - b.getSize()) && b.getX() < rightX){
            //check if Ball is between the y values
            if(b.getY() > y && b.getY() < bottomY){
                //ball and the paddle have collided
                return true;
            }
        }
        //ball has not collided
        return false;
        }
    
}
