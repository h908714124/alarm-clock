package com.digital.alarm;

import com.digital.alarm.view.ClockView;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Clock {
    
    public static void main(String[] args) {

        JFrame frame = ClockView.create();

        SwingUtilities.invokeLater(() -> {
//            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
