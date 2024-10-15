/*
 * File: Target.java
 * Name:
 * Section Leader:
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Target extends GraphicsProgram {

    private static final int OUTER_RADIUS = 72;
    private static final int MIDDLE_RADIUS = 46;
    private static final int INNER_RADIUS = 23;

    public void run() {
        drawTarget();
    }

    private void drawTarget() {
        drawTargetCircle(OUTER_RADIUS, Color.RED);
        drawTargetCircle(MIDDLE_RADIUS, Color.WHITE);
        drawTargetCircle(INNER_RADIUS, Color.RED);
    }

    private void drawTargetCircle(int radius, Color color) {
        GOval oval = new GOval(radius * 2, radius * 2);
        oval.setFilled(true);
        oval.setFillColor(color);
        add(oval, getCenterX(radius), getCenterY(radius));
    }

    private double getCenterX(int radius) {
        return (double) getWidth() / 2 - radius;
    }

    private double getCenterY(int radius) {
        return (double) getHeight() / 2 - radius;
    }
}
