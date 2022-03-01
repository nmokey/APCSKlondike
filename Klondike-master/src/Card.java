import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
	private String imageString;
	private double x;
	private double y;
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

	public void selectCard() {
		isSelected = true;
	}

	public boolean containsPoint(Location thatLoc) {
		if (thatLoc.getX() >= loc.getX() && thatLoc.getX() >= loc.getX() + 71 && thatLoc.getY() <= loc.getY()
				&& thatLoc.getY() >= loc.getY() - 96) {
			return true;
		}
		return false;
	}

	public void openImage(){
		// String s = "APCSKlondike/Klondike-master/images/cards/";
		String s = "images/cards/";
			File backFile = new File(s + "b1fv.png");
			try {
				System.out.println(backFile);
				back=ImageIO.read(backFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			File frontFile = new File(s += ss[suit] + vs[value] + ".png");
			try {
				System.out.println(frontFile);
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
		System.out.println("drawing "+this + " image: "+front);
		if(this.isFaceUp)
			g.drawImage(front, (int) loc.getX(), (int) loc.getY(), null);
		else
			g.drawImage(this.back, (int) loc.getX(), (int) loc.getY(), null);
	}

	@Override
	public String toString() {
		return ss[suit] + " of " + vs[value];
	}

	public Location getLocation(){
		return loc;
	}
	
	public void setLocation(Location loc2) {
		this.loc = loc2;

	}

    public void flip() {
		this.isFaceUp = !isFaceUp;
    }
}
