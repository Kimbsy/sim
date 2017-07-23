package com.kimbsy.sim.sprite;

import java.awt.*;

/**
 * This class is a basic abstract implementation of the {@link Sprite} interface.
 *
 * @author com.kimbsy
 */
public abstract class BaseSprite implements Sprite {

    private Point pos;
    private boolean visible;

    /**
     * Default class constructor.
     * <p>
     * Initialises the position to (0, 0).
     */
    public BaseSprite() {
        this.pos = new Point(0, 0);
        visible = true;
    }

    /**
     * Class constructor specifying the position coordinates.
     *
     * @param pos The position coordinates.
     */
    public BaseSprite(Point pos) {
        this.pos = pos;
        visible = true;
    }

    @Override
    public Point getPos() {
        return pos;
    }

    @Override
    public void setPos(Point pos) {
        this.pos = pos;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public abstract void draw(Graphics2D g2d);
}
