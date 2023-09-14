// 3.Write a program to draw the pie chart in 2D
package lab;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab3PieChart extends JPanel {

    private final double[] values;
    private final String[] labels;
    private final Color[] colors;

    public Lab3PieChart(double[] values, String[] labels, Color[] colors) {
        this.values = values;
        this.labels = labels;
        this.colors = colors;
    }

    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        double total = 0;

        for (double value : values) {
            total += value;
        }
        double angle1 = 0;
        double angle2 = 0;
        for (int i = 0; i < values.length; i++) {
            angle1 = angle2;
            angle2 = angle1 + (360 * (values[i] / total));

            g2d.setColor(colors[i]);
            g2d.fill(new Arc2D.Double(0, 0, getWidth(), getHeight(), angle1, angle2 - angle1, Arc2D.PIE));

            Rectangle2D.Double rect = new Rectangle2D.Double(getWidth() + 10, i * 20, 10, 10);
            g2d.fill(rect);

            g2d.setColor(Color.BLACK);
            g2d.drawString(labels[i], (float) (getWidth() + 25), (float) (i * 20 + 10));
        }
    }

    public static void main(String[] args) {
        double[] values = { 20, 10, 30, 40 };
        String[] labels = { "A", "B", "C", "D" };
        Color[] colors = { Color.CYAN, Color.GREEN, Color.ORANGE, Color.PINK };

        JFrame frame = new JFrame("Pie Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        Lab3PieChart chart = new Lab3PieChart(values, labels, colors);
        frame.add(chart);

        frame.setVisible(true);
    }
}