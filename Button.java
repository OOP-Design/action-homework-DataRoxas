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
        f.show();
    }
}

class MyFrame extends JFrame{
    private MyPanel panel = new MyPanel();
    public MyFrame(){
        setSize(600,600);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                String c = Character.toString(e.getKeyChar());
                panel.letters.add(c);
                repaint();
            }
        });
    }

}

class MyPanel extends JPanel{
    ArrayList<String> letters = new ArrayList<>();
    ArrayList<Point> points = new ArrayList<>();

    public MyPanel(){
        addMouseListener(new MouseAdapter() {
            public void MouseDragged(MouseEvent e){
                int button = e.getButton();
                System.out.println(button);
                if(button == 1){
                    letters.clear();
                    repaint();
                }
            }
        });
        letters.add(Character.toString('c'));
        for(int i = 0; i < 600; i++){
            Point newpoint = new Point((int) (Math.random() * 600), (int) (Math.random() * 600));
            points.add(newpoint);
        }
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for(String letter: letters){
            Point randpoint = getRandomPoint();
            g2.drawString(letter, (int) randpoint.getX(),(int) randpoint.getY());
        }
    }

    public Point getRandomPoint(){
        return points.get((int) (Math.random() * 600));
    }

    //# Write a method to reset the panel
}
