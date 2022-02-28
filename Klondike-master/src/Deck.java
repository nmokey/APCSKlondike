import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Deck implements Drawable, Updateable{
    private ArrayList<Card> cards = new ArrayList<>();
    
    public Deck(){
        for(int i=0;i<4;i++){
            for(int j=0;j<13;j++){
                cards.add(new Card(i,j));
            }
        }
        System.out.println(cards);
    }

    @Override
    public void draw(Graphics g) {
        if(cards.size()>0){
            cards.get(cards.size()-1).draw(g);
        }        
    }

    @Override
    public void update(ActionEvent a) {
        // TODO Auto-generated method stub
        
    }
}
