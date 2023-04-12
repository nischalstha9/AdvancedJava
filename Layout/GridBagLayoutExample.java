package Layout;

import java.awt.GridBagConstraints;
import java.awt.*;
import java.swing.*;

public class GridBagLayoutExample extends JFrame {
    public static void main(String[] args) {
        new GridBagLayoutExample();
    }

    GridBagLayoutExample() {
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(grid);
        setTitle("Grid Bag layout example");
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new Button("Button One").gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;

    }
}
