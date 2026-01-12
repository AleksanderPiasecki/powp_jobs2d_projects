package edu.kis.powp.jobs2d;

import edu.kis.powp.jobs2d.visitor.VisitableJob2dDriver;
import edu.kis.powp.jobs2d.visitor.DriverVisitor;

class MockDriver implements VisitableJob2dDriver {

    int x = 0;
    int y = 0;

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void operateTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void accept(DriverVisitor visitor) {
    }
}
