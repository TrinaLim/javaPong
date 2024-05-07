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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    //declaring and initalizing a game panel
    static JFrame frame = new JFrame("Pong Game");
    
    public static void main(String[] args) {
        //game panel closes on 'X'
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // game panel size
        frame.setSize(690, 495);
        
        //initializing new game
        PongGame game = new PongGame();
        //add to JFrame
        frame.add(game);
        
        // making panel visible
        frame.setVisible(true);
        
        //render frames per second
        Timer timer = new Timer(33, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //calling gameLogic
                game.gameLogic();
                //refresh screen
                game.repaint();
            }
        });
        //start the timer after it's been created
        timer.start();
    }
    
}
