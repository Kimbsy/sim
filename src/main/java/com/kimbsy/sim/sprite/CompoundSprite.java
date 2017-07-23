package com.kimbsy.sim.sprite;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class has a {@link Map} of child {@link Sprite} object {@link Set}s which get drawn along with the parent {@link
 * Sprite}.
 *
 * @author com.kimbsy
 */
public abstract class CompoundSprite<K> extends BaseSprite {

    private Map<K, Set<Sprite>> children;

    /**
     * Default class constructor.
     * <p>
     * Initialises the children to an empty map of {@link Sprite} sets.
     */
    public CompoundSprite() {
        super();
        this.children = new HashMap<K, Set<Sprite>>();
    }

    /**
     * Class constructor specifying the position coordinates of the parent as well as the map of child {@link Sprite}
     * set objects.
     *
     * @param pos      The position coordinates.
     * @param children The map of child {@link Sprite} objects.
     */
    public CompoundSprite(Point pos, Map<K, Set<Sprite>> children) {
        super(pos);
        this.children = children;
    }

    /**
     * Set the child {@link Sprite} set map.
     *
     * @param children The map of child {@link Sprite} objects.
     */
    public void setChildren(Map<K, Set<Sprite>> children) {
        this.children = children;
    }

    public Map<K, Set<Sprite>> getChildren() {
        return children;
    }

    /**
     * Add a new {@link Sprite} to the appropriate set of children.
     *
     * @param key    The key of the group this {@link Sprite} object belongs to.
     * @param sprite The new {@link Sprite} object to add.
     */
    public void addChild(K key, Sprite sprite) {
        if (children.get(key) == null) {
            children.put(key, new HashSet<Sprite>());
        }
        children.get(key).add(sprite);
    }

    /**
     * Remove a {@link Sprite} from the appropriate set of children.
     *
     * @param key    The key of the group this {@link Sprite} object belongs to.
     * @param sprite The {@link Sprite} to remove.
     */
    public void removeChild(K key, Sprite sprite) {
        if (children.get(key) != null) {
            children.remove(sprite);
        }
    }

    @Override
    public void draw(Graphics2D g2d) {
        drawSelf(g2d);

        for (K key : getKeyOrder()) {
            Set<Sprite> group = children.get(key);
            if (group != null && !group.isEmpty()) {
                for (Sprite child : group) {
                    if (child.isVisible()) {
                        child.draw(g2d);
                    }
                }
            }
        }
    }

    /**
     * Get the order the child {@link Sprite} groups should be drawn in.
     *
     * @return The set of group keys in order.
     */
    public abstract LinkedHashSet<K> getKeyOrder();

    /**
     * Draw the parent {@link Sprite} object.
     *
     * @param g2d The graphics object.
     */
    public abstract void drawSelf(Graphics2D g2d);
}
