import java.awt.event.*;

public interface Updateable {
    /**@param a the ActionEvent that cause this update request.
     * This will usually be called based on a Timer event occurring.
     */
    void update(ActionEvent a);
}
