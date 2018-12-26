package com.digital.alarm.presenter;

import com.digital.alarm.view.ClockFrame;
import com.digital.alarm.view.ClockView;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class AlarmClockPresenter implements MinusButtonListener, PlusButtonListener {

    private final ClockView view;

    public void run() {
        SwingUtilities.invokeLater(() -> {
          JFrame frame = view.asFrame();
          frame.getRootPane().getRootPane().registerKeyboardAction(e -> frame.dispose(),
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.pack();
          frame.setVisible(true);
        });
    }

    private AlarmClockPresenter(ClockView view) {
        this.view = view;
    }

    public static AlarmClockPresenter create() {
        ClockView view = ClockFrame.create();
        return new AlarmClockPresenter(view);
    }

    @Override
    public void onMinusButtonPressed() {

    }

    @Override
    public void onPlusButtonPressed() {

    }
}
