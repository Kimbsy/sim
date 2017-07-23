package com.kimbsy.sim;

import com.kimbsy.sim.sprite.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * This class is responsible for drawing to the window and relaying mouse and key events to the {@link Sim} for
 * handling.
 *
 * @author com.kimbsy
 */
public class BaseSimFrame extends JFrame implements SimFrame {

    private Sim sim;
    private int frameDelay;
    private BufferedImage backBuffer;
    private Graphics2D g2d;
    private AffineTransform identity;

    /**
     * Class constructor specifying the parent {@link Sim}.
     *
     * @param sim The {@link Sim} object,
     */
    BaseSimFrame(Sim sim, String title) {
        super(title);
        this.sim = sim;
        this.frameDelay = sim.getFrameDelay();
    }

    @Override
    public Sim getSim() {
        return sim;
    }

    @Override
    public void init() {
        setSize(sim.getWidth(), sim.getHeight());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        identity = new AffineTransform();
        backBuffer = new BufferedImage((sim.getWidth() * 2), (sim.getHeight() * 2), BufferedImage.TYPE_INT_RGB);
        g2d = backBuffer.createGraphics();

        addMouseListener(this);
        addMouseMotionListener(this);
        addMouseWheelListener(this);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backBuffer, 0, 0, this);

        g2d.setTransform(identity);

        for (Sprite sprite : sim.getSprites()) {
            if (sprite.isVisible()) {
                sprite.draw(g2d);
            }
        }
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();

        while (t == sim.getSimLoop()) {
            try {
                sim.update();
                Thread.sleep(frameDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        sim.onMouseClicked(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        sim.onMousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        sim.onMouseReleased(mouseEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        sim.onMouseEntered(mouseEvent);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        sim.onMouseExited(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        sim.onMouseDragged(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        sim.onMouseMoved(mouseEvent);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
        sim.onMouseWheelMoved(mouseWheelEvent);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        sim.onKeyTyped(keyEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        sim.onKeyPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        sim.onKeyReleased(keyEvent);
    }
}
