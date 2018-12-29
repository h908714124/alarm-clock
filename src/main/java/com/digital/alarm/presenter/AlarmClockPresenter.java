package com.digital.alarm.presenter;

import com.digital.alarm.view.ClockFrame;
import com.digital.alarm.view.ClockView;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;

public class AlarmClockPresenter implements MinusButtonListener, PlusButtonListener {

    private final ClockView view;

    private int hours = 12;

    private int minutes = 34;

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
        ClockFrame view = ClockFrame.create();
        AlarmClockPresenter presenter = new AlarmClockPresenter(view);
        view.setMinusListener(presenter);
        view.setPlusListener(presenter);
        presenter.render();
        return presenter;
    }

    private void render() {
        view.setMinuteRight(minutes % 10);
        view.setMinuteLeft(minutes / 10);
        view.setHourRight(hours % 10);
        view.setHourLeft(hours / 10);
    }

    @Override
    public void onMinusButtonPressed() {
        minutes--;
        render();
    }

    @Override
    public void onPlusButtonPressed() {
        minutes++;
        render();
    }
}
