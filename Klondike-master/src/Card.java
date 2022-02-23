import java.util.ArrayList;
import java.util.List;
import java.awt.Image;

public abstract class Card implements Drawable, Updateable {
	private int value, suit;
	private Location loc;
	private Boolean isFaceUp, isSelected;
	private Image front;
	private static Image back;
	private static String[] ss = new String[] { "c", "d", "h", "s" },
			vs = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k" };

	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
		this.loc = new Location(0, 0);
		openImage();
	}

	public Card(int suit, int value, int x, int y) {
		this.suit = suit;
		this.value = value;
		this.loc = new Location(x, y);
	}

	public int compareTo(Card c) {
		return this.value - c.value;
	}

	public void moveTo(Location other) {
		loc = other;
	}

	public void openImage() {
		String s = "Klondike-master/images/cards/";
		if (!isFaceUp) {
			s+="b1fv.png";
		} else {
			s+=ss[suit]+vs[value]+".png";
		}
	}

	// @Override
	// public String toString() {
	// 	String s = "";
	// 	if (value < 11) {
	// 		s += value;
	// 	} else {
	// 		s += valuesSuits.get(value - 6);
	// 	}
	// 	return s += " of " + valuesSuits.get(suit);
	// }
}
