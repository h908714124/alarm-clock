package com.digital.alarm.presenter;

import com.digital.alarm.model.Time;
import com.digital.alarm.view.ClockView;

import javax.swing.JFrame;

public class AlarmClockPresenter implements HoursListener, MinutesListener {

    private final Time time;

    private final ClockView view;

    public AlarmClockPresenter(ClockView view, Time time) {
        this.view = view;
        this.time = time;
        render();
    }

    private void render() {
        view.setMinuteRight(time.getMinuteRight());
        view.setMinuteLeft(time.getMinuteLeft());
        view.setHourRight(time.getHourRight());
        view.setHourLeft(time.getHourLeft());
    }

    @Override
    public void onPlusMinute() {
        time.incrementMinute();
        render();
    }

    @Override
    public void onMinusMinute() {
        time.decrementMinute();
        render();
    }

    @Override
    public void onPlusHour() {
        time.incrementHour();
        render();
    }

    @Override
    public void onMinusHour() {
        time.decrementHour();
        render();
    }

    public JFrame getFrame() {
        return view.asFrame();
    }
}
