package ActionListener;

import javax.swing.*;
import java.awt.event.*;

class Handler implements ActionListener {
    AEvent ed;

    Handler(AEvent e) {
        ed = e;
    }

    public void actionPerformed(ActionEvent e) {
        ed.tf.setText("Welcome");
    }
}

public class AEvent extends JFrame {
    JTextField tf;

    AEvent() {
        tf = new JTextField();
        tf.setBounds(60, 50, 170, 20);
        JButton b = new JButton("Click Me");
        b.setBounds(100, 120, 80, 30);
        b.addActionListener(new Handler(this));
        add(b);
        add(tf);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AEvent();
    }
}
