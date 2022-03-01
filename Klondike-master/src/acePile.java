import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class AcePile extends Pile{
    public AcePile(int x, int y) {
        super(x, y);
        //TODO Auto-generated constructor stub
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
}
