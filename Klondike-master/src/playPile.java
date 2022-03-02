import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class PlayPile extends Pile {
    public PlayPile(int x, int y) {
        super(x, y);
        // TODO Auto-generated constructor stub
    }

    public void addPlayCard(Card c) { // only called when constructing
        addCard(c);
        c.setLocation(c.getLocation().incrementLocVert(c.getLocation(), cards.size()));
        if (cards.size() > 1)
            cards.get(cards.size() - 2).flip();
        cards.get(cards.size() - 1).flip();
    }

    @Override
    public void draw(Graphics g) {
        if (!this.isEmpty()) {
            for (Card c : cards) {
                c.draw(g);
            }
        } else {
            g.setColor(new Color(255, 255, 255, 100));
            g.fillRoundRect((int) loc.getX(), (int) loc.getY(), 71, 96, 10, 10);
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
