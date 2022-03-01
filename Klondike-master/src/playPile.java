import java.awt.Graphics;
import java.awt.event.ActionEvent;

public class PlayPile extends Pile{
    public PlayPile(int x, int y) {
        super(x, y);
        //TODO Auto-generated constructor stub
    }

    public void addPlayCard(Card c){
        addCard(c);
        c.setLocation(c.getLocation().incrementLoc(c.getLocation(), cards.size()));
        if(cards.size()>1)
            cards.get(cards.size()-2).flip();
        cards.get(cards.size()-1).flip();
    }

    @Override
    public void draw(Graphics g) {
        // for(int i=0;i<cards.size();i++){
        //     cards.get(i).setLocation(cards.get(i).getLocation().incrementLoc(cards.get(i).getLocation(), i));
        // }
        // cards.get(cards.size()-1).flip();
        for (Card c:cards) {
            c.draw(g);
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
