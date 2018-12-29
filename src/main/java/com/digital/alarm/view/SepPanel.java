package com.digital.alarm.view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

final class SepPanel extends JPanel {

    private static final String IMAGE = "sep.png";

    private SepPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(ViewUtil.width(54));
    }

    static JPanel create() {
        return new SepPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(IMAGE));
            g.drawImage(img, 0, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
