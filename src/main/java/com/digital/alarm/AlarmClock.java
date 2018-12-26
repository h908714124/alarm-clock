package com.digital.alarm;

import com.digital.alarm.presenter.AlarmClockPresenter;
import com.digital.alarm.view.ClockFrame;
import com.digital.alarm.view.ClockView;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AlarmClock {

    public static void main(String[] args) {

        AlarmClockPresenter presenter = AlarmClockPresenter.create();
        presenter.run();
    }
}
