import java.awt.event.ActionEvent;

public class AcePile extends Pile {
    public AcePile(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean canAddCard(Card c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean gotClicked(Location thatLoc) {
        if (thatLoc.getX() >= loc.getX() && thatLoc.getX() <= loc.getX() + 71 && thatLoc.getY() >= loc.getY()
                && thatLoc.getY() <= loc.getY() + 96) {
            return true;
        }
        return false;
    }
}
