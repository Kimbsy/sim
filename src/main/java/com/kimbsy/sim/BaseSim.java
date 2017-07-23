package com.kimbsy.sim;

import com.kimbsy.sim.sprite.Sprite;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * This class contains common functionality shared by all concrete child {@link Sim} classes.
 *
 * @author kimbsy
 */
public class BaseSim implements Sim {

    private int width, height;
    private String title;

    private Thread simLoop;
    private SimFrame simFrame;
    private int frameDelay;
    private Set<Sprite> sprites;

    @Override
    public SimFrame getSimFrame() {
        return simFrame;
    }

    @Override
    public Thread getSimLoop() {
        return simLoop;
    }

    @Override
    public void setWindowSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setFrameDelay(int frameDelay) {
        this.frameDelay = frameDelay;
    }

    @Override
    public int getFrameDelay() {
        return frameDelay;
    }

    @Override
    public void init() {
        initSprites();
        simFrame = new BaseSimFrame(this, getTitle());
        simLoop = new Thread(simFrame);
        simLoop.start();
        simFrame.init();
    }

    @Override
    public void initSprites() {
        this.sprites = new HashSet<Sprite>();
    }

    @Override
    public void setSprites(Set<Sprite> sprites) {
        this.sprites = sprites;
    }

    @Override
    public Set<Sprite> getSprites() {
        return sprites;
    }

    @Override
    public void update() {
        // no-op.
    }

    @Override
    public void onMouseClicked(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMousePressed(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMouseReleased(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMouseEntered(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMouseExited(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMouseDragged(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMouseMoved(MouseEvent mouseEvent) {
        // no-op.
    }

    @Override
    public void onMouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        // no-op.
    }

    @Override
    public void onKeyTyped(KeyEvent keyEvent) {
        // no-op.
    }

    @Override
    public void onKeyPressed(KeyEvent keyEvent) {
        // no-op.
    }

    @Override
    public void onKeyReleased(KeyEvent keyEvent) {
        // no-op.
    }
}
