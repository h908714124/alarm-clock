package com.digital.alarm.view;

import com.digital.alarm.presenter.MinusButtonListener;
import com.digital.alarm.presenter.PlusButtonListener;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.AWTEvent;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ClockFrame extends JFrame implements ClockView {

    private final DigitView digit0 = DigitView.create();

    private final DigitView digit1 = DigitView.create();

    private final DigitView digit2 = DigitView.create();

    private final DigitView digit3 = DigitView.create();

    private MinusButtonListener minusListener;

    private PlusButtonListener plusListener;

    private ClockFrame() throws HeadlessException {
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setSize(ViewUtil.width(1024));
        add(digit0);
        add(digit1);
        add(createSep());
        add(digit2);
        add(digit3);

        Toolkit.getDefaultToolkit().addAWTEventListener(__ -> {
            if (!(__ instanceof KeyEvent)) {
                return;
            }
            KeyEvent e = (KeyEvent) __;
            if (e.getID() == KeyEvent.KEY_RELEASED) {
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                plusListener.onPlusButtonPressed();
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                minusListener.onMinusButtonPressed();
            }
        }, AWTEvent.KEY_EVENT_MASK);
        setLocationRelativeTo(null);
    }

    public void setMinusListener(MinusButtonListener minusListener) {
        this.minusListener = minusListener;
    }

    public void setPlusListener(PlusButtonListener plusListener) {
        this.plusListener = plusListener;
    }

    private static final class SepPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            try {
                BufferedImage img = ImageIO.read(getClass().getResource("sep.png"));
                g.drawImage(img, 0, 0, null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private JPanel createSep() {
        JPanel panel = new SepPanel();
        panel.setPreferredSize(ViewUtil.width(44));
        panel.repaint();
        return panel;
    }

    public static ClockFrame create() {
        return new ClockFrame();
    }

    @Override
    public void setHourLeft(int hourLeft) {
        checkDigit(hourLeft);
        digit0.setDigit(hourLeft);
        digit0.repaint();
    }

    @Override
    public void setHourRight(int hourRight) {
        checkDigit(hourRight);
        digit1.setDigit(hourRight);
        digit1.repaint();
    }

    @Override
    public void setMinuteLeft(int minuteLeft) {
        checkDigit(minuteLeft);
        digit2.setDigit(minuteLeft);
        digit2.repaint();
    }

    @Override
    public void setMinuteRight(int minuteRight) {
        checkDigit(minuteRight);
        digit3.setDigit(minuteRight);
        digit3.repaint();
    }

    private static void checkDigit(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(i + " is negative");
        }
        if (i >= 10) {
            throw new IllegalArgumentException(i + " is multi-digit");
        }
    }

    @Override
    public JFrame asFrame() {
        return this;
    }
}
