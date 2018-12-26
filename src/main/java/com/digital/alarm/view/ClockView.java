package com.digital.alarm.view;

import com.digital.alarm.model.Digit;

import javax.swing.JFrame;

public interface ClockView {

    Digit getHourLeft();

    void setHourLeft(Digit hourLeft);

    Digit getHourRight();

    void setHourRight(Digit hourRight);

    Digit getMinuteLeft();

    void setMinuteLeft(Digit minuteLeft);

    Digit getMinuteRight();

    void setMinuteRight(Digit minuteRight);

    JFrame asFrame();

}
