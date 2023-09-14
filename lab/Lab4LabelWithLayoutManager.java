// 4.Write a program that creates a label displaying any text, with the italics, font size and color with Layout manager
package lab;

import javax.swing.*;
import java.awt.*;

public class Lab4LabelWithLayoutManager {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Label Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Nischal is awesome.");
        label.setFont(new Font("Arial", Font.ITALIC, 40));
        label.setForeground(Color.GREEN);

        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

}
