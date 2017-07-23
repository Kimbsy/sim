package com.kimbsy.sim.sprite;

import java.awt.*;

/**
 * Describes a sprite object which has a position, visibility and the ability to draw itself.
 *
 * @author com.kimbsy
 */
public interface Sprite {

    /**
     * Get the Sprite position.
     *
     * @return The coordinates of the sprite.
     */
    Point getPos();

    /**
     * Set the Sprite position.
     *
     * @param pos The new coordinates of the sprite.
     */
    void setPos(Point pos);

    /**
     * Get whether the Sprite should be drawn.
     *
     * @return True if the Sprite should be visible.
     */
    boolean isVisible();

    /**
     * Set whether the Sprite should be drawn.
     *
     * @param visible True if the Sprite should be visible.
     */
    void setVisible(boolean visible);

    /**
     * Draw the sprite.
     *
     * @param g2d The graphics object.
     */
    void draw(Graphics2D g2d);
}
