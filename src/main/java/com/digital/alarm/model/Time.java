package com.digital.alarm.model;

public class Time {

    private int hours;

    private int minutes;

    private Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public static Time of(int hours, int minutes) {
        return new Time(hours, minutes);
    }

    public Digit getHourLeft() {
        return Digit.values()[Math.floorMod(hours / 10, 10)];
    }

    public Digit getHourRight() {
        return Digit.values()[Math.floorMod(hours, 10)];
    }

    public Digit getMinuteLeft() {
        return Digit.values()[Math.floorMod(minutes / 10, 10)];
    }

    public Digit getMinuteRight() {
        return Digit.values()[Math.floorMod(minutes, 10)];
    }

    public int getMinutes() {
        return minutes;
    }

    public void incrementMinute() {
        minutes++;
    }

    public void decrementMinute() {
        minutes--;
    }

    public void incrementHour() {
        hours++;
    }

    public void decrementHour() {
        hours--;
    }
}
