package com.digital.alarm.view;

import com.digital.alarm.model.Digit;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

class DigitPanel extends JPanel {

    private static final int WIDTH = 180;

    private BufferedImage img;

    private DigitPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        setPreferredSize(ViewUtil.width(WIDTH));
    }

    static DigitPanel create() {
        return new DigitPanel();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

    void setDigit(Digit digit) {
        switch (digit) {
            case ZERO:
                setImage("0.png");
                return;
            case ONE:
                setImage("1.png");
                return;
            case TWO:
                setImage("2.png");
                return;
            case THREE:
                setImage("3.png");
                return;
            case FOUR:
                setImage("4.png");
                return;
            case FIVE:
                setImage("5.png");
                return;
            case SIX:
                setImage("6.png");
                return;
            case SEVEN:
                setImage("7.png");
                return;
            case EIGHT:
                setImage("8.png");
                return;
            case NINE:
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
