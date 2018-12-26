package com.digital.alarm.presenter;

import com.digital.alarm.view.ClockFrame;
import com.digital.alarm.view.ClockView;

public class AlarmClockPresenter implements MinusButtonListener, PlusButtonListener {

    private final ClockView view;

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
