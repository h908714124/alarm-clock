package com.digital.alarm.view;

import com.digital.alarm.model.Digit;

import javax.swing.JFrame;

public interface ClockView {

    void setHourLeft(Digit hourLeft);

    void setHourRight(Digit hourRight);

    void setMinuteLeft(Digit minuteLeft);

    void setMinuteRight(Digit minuteRight);

    JFrame asFrame();

}
