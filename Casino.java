import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.lang.Object;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Casinoo.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class Casino
{
    public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame();
        frame.setTitle("Welcome To The Casino!");
        frame.setLayout(new BorderLayout());
        
        //Double money = 0.0;

        
        String b = "BlackJack";
        String t = "Texas Hold'Em";
        String r = "Roulette";

        String[] choices = {b,t,r};

        final JComboBox<String> cb = new JComboBox<String>(choices);
        //Double e = (Double) JOptionPane.showInputDialog(null,"Welcome to the Casino! \nHow much money would you like to buy in for?");
        //money = e;
        
        String input = (String) JOptionPane.showInputDialog(null,"BlackJack, Texas Hold'Em, or Roulette?");
        System.out.println(input);
        
        if(input.equalsIgnoreCase("Blackjack"))
        {
            Dealer game = new Dealer();
            game.startGame();
        }
        
        if(input.equalsIgnoreCase("Texas Hold'Em") || input.equalsIgnoreCase("Hold'Em"))
        {
            HoldEmDealer game = new HoldEmDealer();
            game.turn();
        }
        
        if(input.equalsIgnoreCase("Roulette"))
        {
            Roulette game = new Roulette();
            game.turn();
        }
        
        
    }
}
