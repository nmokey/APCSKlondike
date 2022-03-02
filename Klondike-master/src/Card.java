import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Card implements Drawable, Updateable {
	private int value, suit;
	private Location loc;
	private Boolean isFaceUp = false, isSelected = false;
	private Image front;
	private static Image back;
	private static String[] ss = new String[] { "c", "d", "h", "s" },
			vs = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k" };

	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
		this.loc = new Location(100, 100);
		openImage();
	}

	public Card(int suit, int value, int x, int y) {
		this(suit, value);
		this.loc = new Location(x, y);
	}

	public int compareTo(Card c) {
		return this.value - c.value;
	}

	public void moveTo(Location other) {
		loc = other;
	}

	public boolean containsPoint(Location thatLoc) {
		if (thatLoc.getX() >= loc.getX() && thatLoc.getX() <= loc.getX() + 71 && thatLoc.getY() >= loc.getY()
				&& thatLoc.getY() <= loc.getY() + 96) {
			return true;
		}
		return false;
	}

	public void openImage(){
		// String s = "APCSKlondike/Klondike-master/images/cards/";
		String s = "Klondike-master/images/cards/";
			File backFile = new File(s + "b1fv.png");
			try {
				back=ImageIO.read(backFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			File frontFile = new File(s += ss[suit] + vs[value] + ".png");
			try {
				front=ImageIO.read(frontFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void update(ActionEvent a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		//System.out.println("drawing "+this); 
		if(this.isFaceUp && this.isSelected){
			g.drawImage(front, (int) loc.getX(), (int) loc.getY(), null);
			g.setColor(new Color(0,0,255,50));
			g.fillRoundRect((int)loc.getX()-5, (int)loc.getY()-5, 81, 106, 10, 10);
		}
		else if(this.isFaceUp){
			g.drawImage(front, (int) loc.getX(), (int) loc.getY(), null);
		}
		else
			g.drawImage(this.back, (int) loc.getX(), (int) loc.getY(), null);
	}

	@Override
	public String toString() {
		return vs[value] + " of " + ss[suit];
	}

	public Location getLocation(){
		return loc;
	}

	public int getValue(){
		return value;
	}

	public int getSuit(){
		return suit;
	}

	public Boolean isOppositeColor(Card other){
		if((this.suit==0||this.suit==3)&&(other.suit==1||other.suit==2)){
			return true;
		}
		else if((other.suit==0||other.suit==3)&&(this.suit==1||this.suit==2)){
			return true;
		}
		return false;
	}

	public void setLocation(Location loc2) {
		this.loc = loc2;
	}

    public void flip() {
		this.isFaceUp = !isFaceUp;
    }

	public void toggleSelect() {
		this.isSelected = !isSelected;
	}
}
