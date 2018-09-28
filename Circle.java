import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
public class Circle{
  public static void main(String[] args){
    MyFrame f = new MyFrame();
    MyPanel p = new MyPanel();
    f.add(p);
    f.setVisible(true);
  }
}

class MyFrame extends JFrame{
 public MyFrame(){
   super("Circle");
   setSize(400,400);
   setResizable(false);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   /*
   MyPanel p = new MyPanel();
   add(p);
   */
 }
}

class MyPanel extends JPanel{
  MyCircle basecircle = new MyCircle(20, 20, 100);
  public MyPanel(){
    // MyCircle basecircle = new MyCircle(20, 20, 10);
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        //int x = (int) b.getX();
        //int y =  (int) b.getY();
        if(Math.sqrt(Math.pow(basecircle.getx() - b.getX(), 2) + Math.pow(basecircle.gety() - b.getY(), 2)) < 50){
            basecircle.setX((int) (Math.random() * 299));
            basecircle.setY((int) (Math.random() * 299));
          //basecircle = new MyCircle((int) (Math.random() * 350), (int) (Math.random() * 350), 10);
        }
          repaint();
      }
    });
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    //MyCircle circle = new MyCircle((int)(Math.random() * 299), (int)(Math.random() * 299), 10);
    //circle.drawCircle(g2);
    basecircle.drawCircle(g2);
    }
  }


class MyCircle{
  private int x;
  private int y;
  private int diameter;
  public MyCircle(int x,int y,int diameter){
    this.x = x;
    this.y = y;
    this.diameter = diameter;
  }
  public void drawCircle(Graphics2D g){
    g.fillOval(x,y,diameter,diameter);
  }
  public int getx(){
    return x;
  }
  public int gety(){
    return y;
  }
  public void setX(int newX){
      this.x = newX;
  }
  public void setY(int newY){
      this.y = newY;
  }
}
