package com.digital.alarm.view;

import com.digital.alarm.model.Digit;
import com.digital.alarm.presenter.HoursListener;
import com.digital.alarm.presenter.MinutesListener;

import javax.swing.JFrame;
import java.awt.AWTEvent;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class ClockFrame extends JFrame implements ClockView {

    private final DigitPanel digit0 = DigitPanel.create();

    private final DigitPanel digit1 = DigitPanel.create();

    private final DigitPanel digit2 = DigitPanel.create();

    private final DigitPanel digit3 = DigitPanel.create();

    private HoursListener hoursListener;

    private MinutesListener minutesListener;

    private ClockFrame() throws HeadlessException {
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        setLayout(layout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setSize(ViewUtil.width(1024));
        add(digit0);
        add(digit1);
        add(SepPanel.create());
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
            int code = e.getKeyCode();
            if (code == KeyEvent.VK_UP) {
                hoursListener.onPlusHour();
            } else if (code == KeyEvent.VK_DOWN) {
                hoursListener.onMinusHour();
            } else if (code == KeyEvent.VK_LEFT) {
                minutesListener.onMinusMinute();
            } else if (code == KeyEvent.VK_RIGHT) {
                minutesListener.onPlusMinute();
            }
        }, AWTEvent.KEY_EVENT_MASK);
        setLocationRelativeTo(null);
    }

    public void setHoursListener(HoursListener hoursListener) {
        this.hoursListener = hoursListener;
    }

    public void setMinutesListener(MinutesListener minutesListener) {
        this.minutesListener = minutesListener;
    }

    public static ClockFrame create() {
        return new ClockFrame();
    }

    @Override
    public void setHourLeft(Digit hourLeft) {
        digit0.setDigit(hourLeft);
        digit0.repaint();
    }

    @Override
    public void setHourRight(Digit hourRight) {
        digit1.setDigit(hourRight);
        digit1.repaint();
    }

    @Override
    public void setMinuteLeft(Digit minuteLeft) {
        digit2.setDigit(minuteLeft);
        digit2.repaint();
    }

    @Override
    public void setMinuteRight(Digit minuteRight) {
        digit3.setDigit(minuteRight);
        digit3.repaint();
    }

    @Override
    public JFrame asFrame() {
        return this;
    }
}
