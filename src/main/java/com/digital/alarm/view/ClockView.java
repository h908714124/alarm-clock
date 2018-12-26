package com.digital.alarm.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;

public class ClockView extends JFrame {

    private static final int HEIGHT = 200;

    private ClockView() throws HeadlessException {
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        setLocationRelativeTo(null);
        setSize(width(550));
        add(createDigit(Color.BLUE));
        add(createDigit(Color.BLACK));
        add(createDigit(Color.RED));
        add(createDigit(Color.YELLOW));
        add(createDigit(Color.GREEN));
    }

    public static ClockView create() {
        return new ClockView();
    }

    private static JPanel createDigit(Color color) {
        JPanel frame = new JPanel();
        frame.setBackground(color);
        frame.setSize(width(100));
        frame.setMinimumSize(width(100));
        frame.setPreferredSize(width(100));
        return frame;
    }

    private static Dimension width(int width) {
        return new Dimension(width, HEIGHT);
    }

}
