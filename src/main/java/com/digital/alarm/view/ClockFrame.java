package com.digital.alarm.view;

import com.digital.alarm.model.Digit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

public class ClockFrame extends JFrame implements ClockView {

    private ClockFrame() throws HeadlessException {
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setLocationRelativeTo(null);
        setSize(ViewUtil.width(550));
        add(DigitView.create());
        add(DigitView.create());
        add(DigitView.create());
        add(DigitView.create());
        add(DigitView.create());
    }

    public static ClockView create() {
        return new ClockFrame();
    }

    private static JPanel createButtons(Color color) {
        JPanel frame = new JPanel();
        frame.setBackground(color);
        frame.setSize(ViewUtil.width(100));
        frame.setMinimumSize(ViewUtil.width(100));
        frame.setPreferredSize(ViewUtil.width(100));
        return frame;
    }

    @Override
    public Digit getHourLeft() {
        return null;
    }

    @Override
    public void setHourLeft(Digit hourLeft) {

    }

    @Override
    public Digit getHourRight() {
        return null;
    }

    @Override
    public void setHourRight(Digit hourRight) {

    }

    @Override
    public Digit getMinuteLeft() {
        return null;
    }

    @Override
    public void setMinuteLeft(Digit minuteLeft) {

    }

    @Override
    public Digit getMinuteRight() {
        return null;
    }

    @Override
    public void setMinuteRight(Digit minuteRight) {

    }

    @Override
    public JFrame asFrame() {
        return this;
    }
}
