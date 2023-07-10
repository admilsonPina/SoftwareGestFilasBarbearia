package view;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CircularPanel extends JPanel {
    private static final long serialVersionUID = 1L;
	private BufferedImage image;

    public CircularPanel(BufferedImage image) {
        this.image = image;
        setPreferredSize(new Dimension(200, 200));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Desenha um círculo no painel
        Ellipse2D circle = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
        g2d.setClip(circle);
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        g2d.dispose();
    }
}