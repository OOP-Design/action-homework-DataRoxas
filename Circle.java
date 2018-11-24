import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
/**
The class which holds the frame, and by extansion panel, to hold the program.
*/
public class Circle{
  public static void main(String[] args){
    MyFrame f = new MyFrame();
    MyPanel p = new MyPanel();
    f.add(p);
    f.setVisible(true);
  }
}
/**
The class MyFrame which creates and stores the frame.
*/
class MyFrame extends JFrame{
/**
The constructor for MyFrame.
*/
 public MyFrame(){
   super("Circle");
   setSize(400,400);
   setResizable(false);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
}
/**
The class MyPanel which creates and stores the panel that displays the circles.
*/
class MyPanel extends JPanel{
  MyCircle basecircle = new MyCircle(20, 20, 100);
  /**
  The constructor for the MyPanel class.
  */
  public MyPanel(){
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        if(Math.sqrt(Math.pow(basecircle.getx() - b.getX(), 2) + Math.pow(basecircle.gety() - b.getY(), 2)) < 50){
            basecircle.setX((int) (Math.random() * 299));
            basecircle.setY((int) (Math.random() * 299));
        }
          repaint();
      }
    });
  }
  /**
  Method to repaint the panel to change the circle's position.
  @param g The graphics that allow for visual gameplay.
  */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    basecircle.drawCircle(g2);
    }
  }

/**
The class MyCircle that defines the shape and position of the circle onscreen.
*/
class MyCircle{
  private int x;
  private int y;
  private int diameter;
  /**
  The constructor for the MyCircle class.
  @param x the x coordinate for the circle (intially)
  @param y the y coordinate for the circle (initially)
  @param diameter the diameter of the circle.
  */
  public MyCircle(int x,int y,int diameter){
    this.x = x;
    this.y = y;
    this.diameter = diameter;
  }
  /**
  The method which draws the circle in the panel.
  @param g The graphics which allow the visualization of the circle.
  */
  public void drawCircle(Graphics2D g){
    g.fillOval(x,y,diameter,diameter);
  }
  /**
  A getter method for retrieving the circle's current x position.
  @return the integer value that portrays the circle's current x position.
  */
  public int getx(){
    return x;
  }
  /**
  A getter method for retrieving the circle's current y position.
  @return the integer value that portrays the circle's current y position.
  */
  public int gety(){
    return y;
  }
  /**
  A method to set the new x position of the circle when moving it.
  @param newX The new x coordinate.
  */
  public void setX(int newX){
      this.x = newX;
  }
  /**
  A method to set the new y position of the circle when moving it.
  @param newY The new y coordinate. 
  */
  public void setY(int newY){
      this.y = newY;
  }
}
