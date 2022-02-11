import java.util.ArrayList;
import java.util.List;

public abstract class Card implements Drawable, Updateable{
    private int value, suit;
	public Location loc;
	public Boolean isFaceUp;
	private static ArrayList<String> valuesSuits = new ArrayList<>(
			List.of("", "Hearts", "Diamonds", "Clubs", "Spades", "Jack", "Queen", "King", "Ace"));

	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
		this.loc = new Location(0,0)
	}

    public Card(int suit, int value, int x, int y){
        this.suit=suit;
        this.value=value;
		this.loc = new Location(x,y);
    }

	@Override
	public int compareTo(Card c) {
		return this.value-c.value;
	}

	public void setLocation(Location other){
		loc = other;
	}

	@Override
	public String toString() {
		String s = "";
		if(value<11){
			s += value;
		}
		else{
			s += valuesSuits.get(value-6);
		}
		return s += " of "+valuesSuits.get(suit);
	}
}
