package Layout;

import java.awt.*;
import java.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutExample {
    JFrame f;

    FlowLayoutExample() {
        f = new JFrame();
        JButton b1 = new JButton("Button b1");
        JButton b2 = new JButton("Button b2");
        JButton b3 = new JButton("Button b3");
        JButton b4 = new JButton("Button b4");
        JButton b5 = new JButton("Button b5");

        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);

        f.setLayout(new FlowLayout(FlowLayout.RIGHT));
        f.setSize(600, 600);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutExample();
    }
}
