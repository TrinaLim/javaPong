/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pongGame;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author dtrin
 */
import java.awt.*;
public class Ball {
    //declaring variables
    private int x, y, cx, cy, speed, size;
    private Color color;
    static final int MAX_SPEED = 7;
    
    //ball constructor 
    public Ball(int x, int y, int cx, int cy, int speed, Color color, int size) {
        this.x = x;
        this.y = y;
        this.cx = cx; //change in x
        this.cy = cy; //change in y
        this.speed = speed;
        this.color = color;
        this.size = size;
    }
    //display ball
    public void paint(Graphics g) {
        //set color
        g.setColor(color);
        //construct ball 
        g.fillOval(x, y, size, size);
    }
    //movement of ball
   public void moveBall() {
       x+=cx;
       y+=cy;
   }
   //reversing ball's change in y value
   public void reverseY(){
    cy *= -1;
   }
   //reversing ball's change in x value
   public void reverseX(){
    cx *= -1;
   }
   //logic for ball to when it hits the wall
   public void bounceOffEdges(int top, int bottom) {
       //if y value is at the bottom of screen
       if(y > bottom) {
           reverseY();
       }
       //if y value is at the top of screen
       if(y < top) {
           reverseY();
       }
      
   }
   public void increaseSpeed(){
        //make sure current speed is less than max speed before incrementing
        if(speed < MAX_SPEED){
            //increase the speed
            speed ++;

            //update cy and cx with the new speed, ensuring that it increases
            // in speed in the direction it intended
            cx = (cx / Math.abs(cx)*speed);
            cy = (cy / Math.abs(cy)*speed);
        }

    }
   //return y value of ball
   public int getY() {
       return y;
   }
   //return x value of ball
   public int getX() {
       return x;
   }
   //return size of ball
   public int getSize() {
       return size;
   }
   //set y value of ball
   public void setY(int y1) {
       y = y1;
   }
   //set x value of ball
   public void setX(int x1) {
       x = x1;
   }
   //set size of ball
   public void setSize(int size1) {
       size = size1;
   }
   //set size of ball
   public void setSpeed(int speed1) {
       speed = speed1;
   }
   //set size of ball
   public void setCx(int cx1) {
       cx = cx1;
   }
   //set size of ball
   public void setCy(int cy1) {
       cy = cy1;
   }
}

