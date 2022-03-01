import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public abstract class Pile implements Drawable, Updateable {
    protected ArrayList<Card> cards = new ArrayList<>();
    private Location loc; //upper left-hand corner
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
        else{
            g.setColor(new Color(255,255,255,100));
            g.drawRect((int)loc.getX(), (int)loc.getY(), 71, 96);
        }
    }
    public abstract boolean canAddCard(Card c);
}
