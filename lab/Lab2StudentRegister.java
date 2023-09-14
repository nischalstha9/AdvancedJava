// 2.Create Student register UI with first name and last name by Instantiating The JFrame Class
package lab;

import javax.swing.*;

public class Lab2StudentRegister {
    JTextField tfUser;
    JPasswordField tfPassword;
    JButton JSubmit;
    JFrame f;

    public Lab2StudentRegister() {
        f = new JFrame("Register");
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
        JSubmit.setText("Register");
        JSubmit.setBounds(180, 90, 150, 25);
        f.add(JSubmit);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new Lab2StudentRegister();
    }
}
