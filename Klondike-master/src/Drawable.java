import java.awt.Graphics;

/** All Objects that might be drawn should implement this 
 * standard interface.  Most GUI elements will be drawn at
 * some point.  These Objects must know their location and
 * how they represent themselves according to their current
 * state.  
 */
public interface Drawable {
    void draw(Graphics g);
}
