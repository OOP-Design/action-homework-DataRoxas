import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
/**
The base class which holds the frame and panel to hold the menu.
*/
public class Menu{
    public static void main(String[] args){
      MyFrame f = new MyFrame();
      f.setVisible(true);
    }
  }
/**
The class that contains the panel.
*/
class MyPanel extends JPanel{
    /**
    Constructor for MyPanel
    */
    public MyPanel(){
    }
}
/**
The class that makes the frame with an original background color, and allows for
switching colors with the use of menus.
*/
class MyFrame extends JFrame{

    private MyPanel panel = new MyPanel();
    /**
    The constructor for MyFrame
    */
    public MyFrame(){

        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        setSize(600, 600);


        add(panel);
        panel.setBackground(Color.RED);
        setResizable(false);
    }
/**
A method that displays the menus at the top of the window.
*/
    public void displayMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new QuitMenu());
        menuBar.add(new ColorMenu());
        setJMenuBar(menuBar);
    }
/**
A class that creates a menu allowing the user to quit the window.
*/
    private class QuitMenu extends JMenu{
        /**
        The constructor for QuitMenu
            that also initiates the ActionListener for exiting the window.
        */
        public QuitMenu(){
            super("Quit Menu");
            JMenuItem quitMI = new JMenuItem("Quit");
            quitMI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            add(quitMI);
        }
    }
    /**
    A class that creates the color menu for changing the background color.
    */
    private class ColorMenu extends JMenu{
        /**
        The constructor for the ColorMenu class.
        */
        public ColorMenu(){
            super("Color Menu");
            for(BackgroundColor color : BackgroundColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name());
                menuItem.addActionListener(new ColorListener(color));
                add(menuItem);
            }
        }
    }
    /**
    A seperate class that creates the ColorListener to be used in the color menu.
    */
    private class ColorListener implements ActionListener{
        private BackgroundColor color;
        public void actionPerformed(ActionEvent e){
            panel.setBackground(color.color);
        }
        public ColorListener(BackgroundColor color){
            this.color = color;
        }
    }
}
/**
An enumeration that holds the colors for the background that can be switched between.
*/
enum BackgroundColor{
    Red(Color.RED), Blue(Color.BLUE), Green(Color.GREEN);
    public Color color;

    BackgroundColor(Color color){
        this.color = color;
    }
    Color color(){
        return color;
    }
}
