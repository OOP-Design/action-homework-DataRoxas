import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public class Menu{
    public static void main(String[] args){
      MyFrame f = new MyFrame();
      f.setVisible(true);
    }
  }

class MyPanel extends JPanel{
    public MyPanel(){
    }
    public void setBackground(Color color){
        MyPanel.setBackground(color);
    }
}

class MyFrame extends JFrame{

    private MyPanel panel = new MyPanel();

    public void MyFrame(){
        panel.setBackground(Color.RED);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        setSize(600, 600);


        add(panel);
        setResizable(false);
    }

    public void displayMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new QuitMenu());
        menuBar.add(new ColorMenu());
        setJMenuBar(menuBar);
    }
    private class QuitMenu extends JMenu{
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
    private class ColorMenu extends JMenu{
        public void ColorMenu(){
            super("Color");
            for(Color color : Color.values()){
                JMenuItem menuItem = new JMenuItem(color.name());
                menuItem.addActionListener(new ColorListener(color));
                add(menuItem);
            }

        }
    }
    private class ColorListener implements ActionListener{
        private Color color;
        public void actionPerformed(ActionEvent e){
            panel.setBackground(color.color);
        }
        public ColorListener(Color color){
            this.color = color;
        }
    }
}
enum Color{
    Red(Color.RED), Blue(Color.BLUE), Green(Color.GREEN);
    public Color color;

    Color(Color color){
        this.color = color;
    }
    Color color(){
        return color;
    }
}
