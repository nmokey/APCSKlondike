import java.util.ArrayList;
import java.awt.Graphics;

public abstract class Pile implements Drawable, Updateable {
    private ArrayList<Card> cards = new ArrayList<>();
    private Location loc; //upper left-hand corner
    public Pile(){}
    
    public void addCard(Card card){
        cards.add(card);
    }

    public boolean isEmpty(){
        return cards.size()==0;
    }
    
    public ArrayList<Card> removeCard(){
        //TODO
        return null;
    }

    public Card getTopCard(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return cards.get(cards.size()-1);
        }
    }

    public Card removeTopCard(){
        if(this.isEmpty()){
            return null;
        }
        else{
            Card top = cards.get(cards.size()-1);
            cards.remove(cards.size()-1);
            return top;
        }
    }

    //for acepile and drawpile
    public void draw(Graphics g){
        if(cards.size()>0){
            cards.get(cards.size()-1).draw(g);
        }
    }
    public abstract boolean canAddCard(Card c);
}
