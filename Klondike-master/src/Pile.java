import java.util.ArrayList;
/** A Pile is a collection of cards.  This needs to be
 * Drawable because it will be shown on the GUI. Put code
 * here that ALL Piles share.  The ways in which Piles are 
 * different belong in the subclasses. The draw method should 
 * be implemented here.  Updateable may have empty implementation.
 * You WILL write subclasses of Pile
 */
public abstract class Pile implements Drawable, Updateable {
    private ArrayList<Card> cards = new ArrayList<>();
    private Location loc; //upper left-hand corner
    public Pile(){}
    
    public void addCard(Card card){
        cards.add(card);
    }

    public ArrayList<Card> removeCard(){
        //TODO
        return null;
    }

    public boolean isEmpty(){
        return cards.size()==0;
    }

    public Card getTopCard(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return cards.get(cards.size()-1);
        }
    }
    public abstract boolean canAddCard(Card c);
}
