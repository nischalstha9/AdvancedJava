package ActionListener;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MouseEventTest implements MouseListener {
    JFrame f;
    JButton b;

    public MouseEventTest() {
        f = new JFrame("Catch me if you can!");
        b = new JButton("Catch me!");
        b.setBounds(20, 20, 180, 40);
        b.addMouseListener(this);
        f.add(b);
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventTest();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        Random rand = new Random();
        int x = rand.nextInt(500);
        int y = rand.nextInt(500);
        b.setBounds(x, y, 180, 40);
    }
}