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
        int d = Math.floorMod(hours / 10, 10);
        return Digit.values()[d];
    }

    public Digit getHourRight() {
        int d = Math.floorMod(hours, 10);
        return Digit.values()[d];
    }

    public Digit getMinuteLeft() {
        int d = Math.floorMod(minutes / 10, 10);
        return Digit.values()[d];
    }

    public Digit getMinuteRight() {
        int d = Math.floorMod(minutes, 10);
        return Digit.values()[d];
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
