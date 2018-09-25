import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
public class CircleGame{
  public static void main(String[] args){
    MyFrame f = new MyFrame();
    f.setVisible(true);
  }
}

class MyFrame extends JFrame{
 public MyFrame(){
   super("Circle Game");
   setSize(400,400);
   setResizable(false);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   MyPanel p = new MyPanel();
   add(p);
 }
}

class MyPanel extends JPanel{
  public MyPanel(){
    MyCircle basecircle = new MyCircle(50, -150, 10);
    repaint();
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        if(x == basecircle.getx() && y == basecircle.gety()){
          MyCircle newcircle = new MyCircle((int) (Math.random() * 350), (int) (Math.random() * 350), 10);
        }
          repaint();
      }
    });
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    MyCircle circle = new MyCircle(((int)Math.random() * 299), (int)(Math.random() * 299), 5);
    MyCircle.drawCircle(g2);
    }
  }


class MyCircle{
  public static int x;
  public static int y;
  private int diameter;
  public MyCircle(int x,int y,int diameter){
    this.x = x;
    this.y = y;
    this.diameter = diameter;
  }
  public void drawCircle(Graphics2D g){
    g.fillOval(x,y,diameter,diameter);
  }
  public static int getx(){
    return x;
  }
  public static int gety(){
    return y;
  }
}
