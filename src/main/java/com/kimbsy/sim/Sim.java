package com.kimbsy.sim;

import com.kimbsy.sim.sprite.Sprite;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Set;

/**
 * Describes a 2D Simulation.
 *
 * @author kimbsy
 */
public interface Sim {

    /**
     * Get the reference to the simulation {@link JFrame}.
     *
     * @return The {@link SimFrame} object.
     */
    SimFrame getSimFrame();

    /**
     * Set the reference to the simulation {@link JFrame}.
     *
     * @param simFrame the {@link SimFrame object}.
     */
    void setSimFrame(SimFrame simFrame);

    /**
     * Get the reference to the main simulation {@link Thread}.
     *
     * @return The {@link Thread} object.
     */
    Thread getSimLoop();

    /**
     * Set the size of the simulation window.
     *
     * @param width  The width of the window.
     * @param height The height of the window.
     */
    void setWindowSize(int width, int height);

    /**
     * Get the width of the simulation window.
     *
     * @return The width of the window.
     */
    int getWidth();

    /**
     * Get the height of the simulation window.
     *
     * @return The height of the window.
     */
    int getHeight();

    /**
     * Set the title of the simulation window.
     *
     * @param title The title of the window.
     */
    void setTitle(String title);

    /**
     * Get the title of the simulation window.
     *
     * @return The title of the window.
     */
    String getTitle();

    void setFrameDelay(int frameDelay);

    int getFrameDelay();

    /**
     * Initialize the set of {@link Sprite} objects to draw.
     */
    void initSprites();

    /**
     * Set the set of {@link Sprite} objects to draw.
     *
     * @param sprites The set of {@link Sprite} objects.
     */
    void setSprites(Set<Sprite> sprites);

    /**
     * Get the set of {@link Sprite} objects to draw.
     *
     * @return The set of {@link Sprite} objects.
     */
    Set<Sprite> getSprites();

    /**
     * Initialize the simulation.
     */
    void init();

    /**
     * Update the simulation state, runs every frame.
     */
    void update();

    /**
     * Implementation method for the {@link MouseListener#mouseClicked} method, invoked by the {@link SimFrame} object.
     */
    void onMouseClicked(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseListener#mousePressed} method, invoked by the {@link SimFrame} object.
     */
    void onMousePressed(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseListener#mouseReleased} method, invoked by the {@link SimFrame}
     * object.
     */
    void onMouseReleased(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseListener#mouseEntered} method, invoked by the {@link SimFrame} object.
     */
    void onMouseEntered(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseListener#mouseExited} method, invoked by the {@link SimFrame} object.
     */
    void onMouseExited(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseMotionListener#mouseDragged} method, invoked by the {@link SimFrame}
     * object.
     */
    void onMouseDragged(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseMotionListener#mouseMoved} method, invoked by the {@link SimFrame}
     * object.
     */
    void onMouseMoved(MouseEvent mouseEvent);

    /**
     * Implementation method for the {@link MouseWheelListener#mouseWheelMoved} method, invoked by the {@link SimFrame}
     * object.
     */
    void onMouseWheelMoved(MouseWheelEvent mouseWheelEvent);

    /**
     * Implementation method for the {@link KeyListener#keyTyped} method, invoked by the {@link SimFrame} object.
     */
    void onKeyTyped(KeyEvent keyEvent);

    /**
     * Implementation method for the {@link KeyListener#keyPressed} method, invoked by the {@link SimFrame} object.
     */
    void onKeyPressed(KeyEvent keyEvent);

    /**
     * Implementation method for the {@link KeyListener#keyReleased} method, invoked by the {@link SimFrame} object.
     */
    void onKeyReleased(KeyEvent keyEvent);
}
