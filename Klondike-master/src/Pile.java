import java.util.ArrayList;

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
