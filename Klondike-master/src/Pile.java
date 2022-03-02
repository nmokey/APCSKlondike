import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public abstract class Pile implements Drawable, Updateable {
    protected ArrayList<Card> cards = new ArrayList<>();
    protected Location loc; //upper left-hand corner

    public Pile(int x, int y){
        loc = new Location(x, y);
    }
    
    public void addCard(Card card){
        cards.add(card);
        card.setLocation(loc);
    }

    public boolean isEmpty(){
        return cards.size()==0;
    }
    
    public void receiveCard(Card c){ //used for card movements in playpiles
        addCard(c);
        c.setLocation(c.getLocation().incrementLocVert(c.getLocation(), cards.size()));
    }

    public Card getTopCard(){ //returns the top card
        if(this.isEmpty()){
            return null;
        }
        return cards.get(cards.size()-1);
    }

    public Card deal(){ //removes and returns the top card
        if(this.isEmpty()){ 
            System.out.println("i dealt a null!"); //testing
            return null;
        }
        else{
            Card top = cards.get(cards.size()-1);
            cards.remove(cards.size()-1);
            return top;
        }
    }

    public void flipTopCard(){ //flips top card of a pile (used after a card is removed from a playpile)
        if(cards.size()>0)
            cards.get(cards.size()-1).flip();
    }

    public void draw(Graphics g){
        if(cards.size()>0){
            cards.get(cards.size()-1).draw(g);
        }
        else{
            g.setColor(new Color(255,255,255,100));
            g.fillRoundRect((int)loc.getX(), (int)loc.getY(), 71, 96, 10, 10);
        }
    }

    public boolean gotClicked(Location loc){
        if(cards.get(cards.size()-1).containsPoint(loc)){
            return true;
        }
        return false;
    }

    public abstract boolean canAddCard(Card c);
}