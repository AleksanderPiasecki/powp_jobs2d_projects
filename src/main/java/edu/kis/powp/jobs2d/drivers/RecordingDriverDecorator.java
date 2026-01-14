package edu.kis.powp.jobs2d.drivers;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.drivers.adapter.LineDriverAdapter;

public class RecordingDriverDecorator implements Job2dDriver {
    private final Job2dDriver targetDriver;

    public RecordingDriverDecorator(Job2dDriver targetDriver) {
        this.targetDriver = targetDriver;
    }

    @Override
    public void setPosition(int x, int y) {
        targetDriver.setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        targetDriver.operateTo(x, y);
    }

    @Override
    public String toString() {
        return "Recording Driver Decorator wrapping: " + targetDriver.toString();
    }
}
