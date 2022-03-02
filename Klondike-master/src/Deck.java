import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Collections;

public class Deck extends Pile implements Drawable, Updateable{    
    public Deck(int x, int y){
        super(x, y);
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                cards.add(new Card(i,j));
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        if(cards.size()>0){
            cards.get(cards.size()-1).draw(g);
        }
        else{
            g.setColor(new Color(255,255,255,100));
            g.fillRoundRect(100, 100, 71, 96, 10, 10);
        }
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
    }


    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void displayTop3(DrawPile p){
        if(cards.size()<=0){
            while(!p.isEmpty()){
                this.addCard(p.deal());
            }
        }
        else if(cards.size()<3){
            while(cards.size()>-1){
                p.addDrawCard(this.deal());
            }
        }
        else{
            for(int i=0;i<3;i++){
                p.addDrawCard(this.deal());
            }
        }
    }

    @Override
    public boolean canAddCard(Card c) {
        // TODO Auto-generated method stub
        return false;
    }
}
