package com.digital.alarm;

import com.digital.alarm.model.Time;
import com.digital.alarm.presenter.AlarmClockPresenter;
import com.digital.alarm.view.ClockFrame;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;

public class AlarmClock {

    public static void main(String[] args) {

        AlarmClockPresenter presenter = create(getTime(args));
        SwingUtilities.invokeLater(() -> {
            JFrame frame = presenter.getFrame();
            frame.getRootPane().getRootPane().registerKeyboardAction(e -> frame.dispose(),
                    KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
                    JComponent.WHEN_IN_FOCUSED_WINDOW);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }

    private static Time getTime(String[] args) {
        if (args.length == 0) {
            return Time.of(12, 34);
        }
        String[] tokens = args[0].split(":", -1);
        return Time.of(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
    }

    private static AlarmClockPresenter create(Time time) {
        ClockFrame view = ClockFrame.create();
        AlarmClockPresenter presenter = new AlarmClockPresenter(view, time);
        view.setHoursListener(presenter);
        view.setMinutesListener(presenter);
        return presenter;
    }

}
