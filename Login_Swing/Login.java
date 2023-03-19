package Login_Swing;

import javax.swing.*;
import java.awt.event.*;

public class Login implements ActionListener {
    JTextField tfUser;
    JPasswordField tfPassword;
    JButton JSubmit;
    JFrame f;

    public Login() {
        f = new JFrame("Login");
        JLabel lUser = new JLabel("Username");
        lUser.setBounds(20, 20, 150, 25);
        f.add(lUser);

        tfUser = new JTextField();
        tfUser.setBounds(180, 20, 150, 25);
        f.add(tfUser);

        JLabel lPassword = new JLabel("Password");
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
        System.out.println(e.getActionCommand());
        String username = tfUser.getText();
        String password = tfPassword.getText();
        if (username.equals("admin") && password.equals("admin")) {
            JDialog dialog = new JDialog(f, "Authenticated", true);
            dialog.setLocationRelativeTo(dialog);
            dialog.setSize(100, 100);
            dialog.setVisible(true);
        } else {
            System.out.println("Wrong Credentials!");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}