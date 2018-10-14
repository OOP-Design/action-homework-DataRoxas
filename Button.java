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
        # Put the keyListener
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                char c = e.getKeyChar();
                if (charList.contains(c)){
                    //Do I add a statement here to add the character to the panel? What would that look like? That?
                    panel.paintComponent();
                }
            }
        });
    }

}

class MyPanel extends JPanel{

    public MyPanel(){
        addMouseListener(new MouseAdapter() {
            public void MouseClicked(MouseEvent e){
                panel.removeAll();

            }
        })
    }


    public void paintComponent(Graphics g){

    }

    public Point getRandomPoint(){
        

    }

    # Write a method to reset the panel
}
