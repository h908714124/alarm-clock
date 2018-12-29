package com.digital.alarm.view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

class DigitView extends JPanel {

    private static final int WIDTH = 180;

    private BufferedImage img;

    private DigitView() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(ViewUtil.width(WIDTH));
    }

    static DigitView create() {
        return new DigitView();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    void setDigit(int digit) {
        switch (digit) {
            case 0:
                setImage("0.png");
                return;
            case 1:
                setImage("1.png");
                return;
            case 2:
                setImage("2.png");
                return;
            case 3:
                setImage("3.png");
                return;
            case 4:
                setImage("4.png");
                return;
            case 5:
                setImage("5.png");
                return;
            case 6:
                setImage("6.png");
                return;
            case 7:
                setImage("7.png");
                return;
            case 8:
                setImage("8.png");
                return;
            case 9:
                setImage("9.png");
                return;
            default:
                throw new IllegalArgumentException("not a digit: " + digit);
        }
    }

    private void setImage(String resource) {
        try {
            this.img = ImageIO.read(getClass().getResource(resource));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
