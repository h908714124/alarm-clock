package com.digital.alarm;

import com.digital.alarm.presenter.AlarmClockPresenter;

public class AlarmClock {

    public static void main(String[] args) {

        AlarmClockPresenter presenter = AlarmClockPresenter.create();
        presenter.run();
    }
}
