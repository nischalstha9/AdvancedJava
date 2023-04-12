package ActionCommand;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

public class ActionCommandExample extends MouseMotionAdapter {
    Frame f;
    JButton b;
    JButton b2;

    ActionCommandExample() {
        f = new Frame("Action Command Example");
        f.addMouseMotionListener(this);

        b = new JButton();
        b.setText("Login");
        b.addActionListener(this);
        b.setActionCommand("loginBtn");
        b.setBounds(180, 90, 150, 25);
        f.add(b);

        b2 = new JButton();
        b2.setText("Register");
        b2.addActionListener(this);
        b2.setActionCommand("registerBtn");
        b2.setBounds(180, 120, 150, 25);
        f.add(b2);

        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd == "loginBtn") {
            System.out.println("Login Btn Pressed");
        }
    }

    public static void main(String[] args) {
        new ActionCommandExample();
    }
}
