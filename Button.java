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
                    //Add it to the charArray in panel. Have pain component display everything in the character Array. When you are ready to delete everything off the panel, you can simply clear out the character array. 
                    repaint();
                }
            }
        });
    }

}

class MyPanel extends JPanel{
    private ArrayList<String> charArray = new ArrayList<>();
    private ArrayList<> pointArray = new ArrayList<>();
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
