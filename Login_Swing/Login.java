package Login_Swing;

import javax.swing.*;
import java.awt.event.*;

public class Login implements ActionListener {
    JTextField tfUser;
    JPasswordField tfPassword;
    JButton JSubmit;

    public Login() {
        JFrame f = new JFrame("Login");
        JLabel lUser = new JLabel("Username");
        lUser.setBounds(20, 20, 150, 25);
        f.add(lUser);

        tfUser = new JTextField();
        tfUser.setBounds(180, 20, 150, 25);
        f.add(tfUser);

        JLabel lPassword = new JLabel("Password");
        // lPassword.setText("Password");
        lPassword.setBounds(20, 55, 150, 25);
        f.add(lPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(180, 55, 150, 25);
        f.add(tfPassword);

        JSubmit = new JButton();
        JSubmit.setText("Login");
        JSubmit.setBounds(180, 90, 150, 25);
        JSubmit.addActionListener(this);
        f.add(JSubmit);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String username = tfUser.getText();
        String password = tfPassword.getText();
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Authenticated!");
        } else {
            System.out.println("Wrong Credentials!");
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}