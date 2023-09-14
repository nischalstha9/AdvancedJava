// 5.Write UI with one button when click on button its color should changed using ActionLister

package lab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab5ActionListener implements ActionListener {
    private JButton button;

    Lab5ActionListener() {
        JFrame frame = new JFrame("Button Color Change");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton button = new JButton("Click Me!");
        button.addActionListener(this);
        this.button = button;

        frame.add(button);
        frame.pack();
        frame.setSize(200, 200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Color currentColor = button.getBackground();
        Color newColor = (currentColor == Color.RED) ? Color.GREEN : Color.RED;
        button.setBackground(newColor);
    }

    public static void main(String[] args) {
        new Lab5ActionListener();
    }
}
