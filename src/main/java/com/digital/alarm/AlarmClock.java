package com.digital.alarm;

import com.digital.alarm.view.ClockFrame;
import com.digital.alarm.view.ClockView;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AlarmClock {

    public static void main(String[] args) {

        ClockView view = ClockFrame.create();

        SwingUtilities.invokeLater(() -> {
            view.asFrame().pack();
            view.asFrame().setVisible(true);
            view.asFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}
