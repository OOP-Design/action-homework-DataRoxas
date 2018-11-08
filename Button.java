import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Button{
    public static void main(String[] args){
        MyFrame f = new MyFrame();
        f.setVisible(true);
    }
}

class MyFrame extends JFrame{
    private MyPanel panel = new MyPanel();
    public MyFrame(){
        setSize(600,600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                String c = Character.toString(e.getKeyChar());
                panel.letters.add(c);
                //Do I add a statement here to add the character to the panel? What would that look like? That?
                repaint();
            }
        });
    }

}

class MyPanel extends JPanel{
    ArrayList<String> letters = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();

    public MyPanel(){
        for(int i = 0; i < 600; i++){
            Point newpoint = new Point((int) (Math.random() * 500), (int) (Math.random() * 500));
            points.add(newpoint);
        }
        addMouseListener(new MouseAdapter() {
            public void MouseClicked(MouseEvent e){
                letters.clear();
                repaint();
            }
        });
    }


    public void paintComponent(Graphics g){
        String letter = letters.get(letters.size() - 1);
        Point randpoint = getRandomPoint();
        g.drawString(letter, (int) randpoint.getX(),(int) randpoint.getY());
    }

    public Point getRandomPoint(){
        return points.get((int) (Math.random() * 600));
    }

    //# Write a method to reset the panel
}
