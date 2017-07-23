package com.kimbsy.sim;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

/**
 * Describes a class to be used by the {@link Sim} object to draw to the window.
 *
 * @author kimbsy
 */
public interface SimFrame extends Runnable, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {

    /**
     * Get the reference to the parent {@link Sim}.
     *
     * @return The {@link Sim} object.
     */
    Sim getSim();

    /**
     * Initialize the {@link SimFrame}.
     */
    void init();
}
