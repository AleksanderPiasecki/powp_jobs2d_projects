package edu.kis.powp.jobs2d.drivers;

import java.util.logging.Logger;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.powp.jobs2d.canvas.CanvasManager;
import edu.kis.powp.jobs2d.canvas.ICanvas;
import edu.kis.powp.jobs2d.features.CanvasFeature;
import edu.kis.powp.jobs2d.visitor.DriverVisitor;
import edu.kis.powp.jobs2d.visitor.VisitableJob2dDriver;

public class CanvasLimitedDriverDecorator implements VisitableJob2dDriver {
	VisitableJob2dDriver targetDriver;

	public CanvasLimitedDriverDecorator(VisitableJob2dDriver targetDriver) {
		this.targetDriver = targetDriver;
	}

	public VisitableJob2dDriver getTargetDriver() {
		return targetDriver;
	}

	public boolean checkCanvasContainsPoint(int x, int y) {
		CanvasManager canvasManager = CanvasFeature.getCanvasManager();
		ICanvas canvas = canvasManager.getCurrentCanvas();
		if (canvas != null && !canvas.containsPoint(x, y)) {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
					.warning("Point (" + x + ", " + y + ") is outside the canvas boundaries.");
			return false;
		}
		return true;
	}

	@Override
	public void setPosition(int x, int y) {
		if (!checkCanvasContainsPoint(x, y)) {
			return;
		}
		targetDriver.setPosition(x, y);
	}

	@Override
	public void operateTo(int x, int y) {
		if (!checkCanvasContainsPoint(x, y)) {
			return;
		}
		targetDriver.operateTo(x, y);
	}

	@Override
	public void accept(DriverVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return "Canvas-limited: " + targetDriver.toString();
	}
}
