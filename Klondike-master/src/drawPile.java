import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class DrawPile extends Pile {
    public DrawPile(int x, int y) {
        super(x, y);
    };

    public void addDrawCard(Card c) {
        addCard(c);
        c.setLocation(c.getLocation().incrementLocHoriz(c.getLocation(), cards.size()));
        c.flip();
    }

    @Override
    public boolean gotClicked(Location thatLoc) {
        if (thatLoc.getX() >= loc.getX() && thatLoc.getX() <= loc.getX() + 71 && thatLoc.getY() >= loc.getY()
                && thatLoc.getY() <= loc.getY() + 96) {
            return true;
        }
        return false;
    }
    
    @Override
    public void draw(Graphics g) {
        if(cards.size()>0){
            for (Card c:cards) {
                c.draw(g);
            }
        }
        else{
            g.setColor(new Color(255,255,255,100));
            g.fillRoundRect((int)loc.getX(), (int)loc.getY(), 111, 96, 10, 10);
        }
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
