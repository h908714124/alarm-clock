package com.digital.alarm.view;

import javax.swing.JFrame;

public interface ClockView {

    void setHourLeft(int hourLeft);

    void setHourRight(int hourRight);

    void setMinuteLeft(int minuteLeft);

    void setMinuteRight(int minuteRight);

    JFrame asFrame();

}
