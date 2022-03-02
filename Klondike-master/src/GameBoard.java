import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class GameBoard implements Drawable, Updateable {
	private Deck deck = new Deck(200, 100);
	private DrawPile drawPile = new DrawPile(200, 100);
	private PlayPile playPile1 = new PlayPile(200 + 100 * 0, 300);
	private PlayPile playPile2 = new PlayPile(200 + 100 * 1, 300);
	private PlayPile playPile3 = new PlayPile(200 + 100 * 2, 300);
	private PlayPile playPile4 = new PlayPile(200 + 100 * 3, 300);
	private PlayPile playPile5 = new PlayPile(200 + 100 * 4, 300);
	private PlayPile playPile6 = new PlayPile(200 + 100 * 5, 300);
	private PlayPile playPile7 = new PlayPile(200 + 100 * 6, 300);
	private AcePile clubs = new AcePile(200 + 100 * 3, 100);
	private AcePile spades = new AcePile(200 + 100 * 4, 100);
	private AcePile hearts = new AcePile(200 + 100 * 5, 100);
	private AcePile diamonds = new AcePile(200 + 100 * 6, 100);

	private Card currentCard;
	private PlayPile currentPile;
	private boolean firstClick = true;
	private int numdraws = 0;
	public static final int OFFSET_X = 40, OFFSET_Y = 20;

	public GameBoard() {
		deck.shuffle();
		playPile1.addPlayCard(deck.deal());
		for (int i = 0; i < 2; i++)
			playPile2.addPlayCard(deck.deal());
		for (int i = 0; i < 3; i++)
			playPile3.addPlayCard(deck.deal());
		for (int i = 0; i < 4; i++)
			playPile4.addPlayCard(deck.deal());
		for (int i = 0; i < 5; i++)
			playPile5.addPlayCard(deck.deal());
		for (int i = 0; i < 6; i++)
			playPile6.addPlayCard(deck.deal());
		for (int i = 0; i < 7; i++)
			playPile7.addPlayCard(deck.deal());
	}

	/**
	 * @param g Graphics context onto which all Objects in the game
	 *          draw themselves. This should NOT change the Objects
	 */
	public void draw(Graphics g) {
		numdraws++;
		g.setColor(new Color(140, 211, 255));
		g.fillRect(0, 0, 3000, 2000);
		// try {
		// g.drawImage(ImageIO.read(new File("images/cards/casinoFelt.jpeg")), 0, 0,
		// null);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		deck.draw(g);
		drawPile.draw(g);
		playPile1.draw(g);
		playPile2.draw(g);
		playPile3.draw(g);
		playPile4.draw(g);
		playPile5.draw(g);
		playPile6.draw(g);
		playPile7.draw(g);
		clubs.draw(g);
		spades.draw(g);
		hearts.draw(g);
		diamonds.draw(g);
	}

	/**
	 * This method is called by the game when a click has been made
	 * on the panel. Must determine if the click makes sense (is it
	 * a valid location, If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * 
	 * @param me
	 */
	public void justClicked(MouseEvent me) {
		Point p = me.getPoint();
		Location clickLoc = new Location(p.getX(), p.getY());
		if (firstClick) {
			firstClick(clickLoc);
		} else {
			secondClick(clickLoc);
		}
	}

	private void firstClick(Location loc) {
		boolean a = firstClickCheck(playPile1, loc) ||
				firstClickCheck(playPile2, loc) ||
				firstClickCheck(playPile3, loc) ||
				firstClickCheck(playPile4, loc) ||
				firstClickCheck(playPile5, loc) ||
				firstClickCheck(playPile6, loc) ||
				firstClickCheck(playPile7, loc);
		if (deck.gotClicked(loc)) {
			deck.displayTop3(drawPile);
		} 
		else if(drawPile.gotClicked(loc)){
			currentCard=drawPile.getTopCard();
			currentCard.toggleSelect();
			firstClick=false;
			currentPile=null;
		}
		else {
			return;
		}
	}

	private boolean firstClickCheck(PlayPile p, Location loc) { // stores a selected card and the pile it's from
		if (!p.isEmpty() && p.gotClicked(loc)) {
			currentCard = p.getTopCard();
			currentCard.toggleSelect();
			firstClick = false;
			currentPile = p;
			return true;
		}
		return false;
	}

	private void secondClick(Location loc) {
		boolean a = secondClickPlayCheck(playPile1, loc) ||
				secondClickPlayCheck(playPile2, loc) ||
				secondClickPlayCheck(playPile3, loc) ||
				secondClickPlayCheck(playPile4, loc) ||
				secondClickPlayCheck(playPile5, loc) ||
				secondClickPlayCheck(playPile6, loc) ||
				secondClickPlayCheck(playPile7, loc);
		secondClickAceCheck(clubs, loc);
		secondClickAceCheck(spades, loc);
		secondClickAceCheck(hearts, loc);
		secondClickAceCheck(diamonds, loc);
	}

	private boolean secondClickPlayCheck(PlayPile p, Location loc) { // checks if a playpile has attempted a legal move
		if (p.gotClicked(loc)) {
			System.out.println("Current card selected: " + currentCard); // testing
			if (p.getTopCard().getValue() == currentCard.getValue() + 1
					&& p.getTopCard().isOppositeColor(currentCard)) {
						if(currentPile==null){ //if current pile was stored as null, then the card is from the drawpile.
							p.receiveCard(drawPile.deal());
							currentCard.toggleSelect();
							currentCard=null;
							firstClick=true;
						}
				else{
					p.receiveCard(currentPile.deal());
					currentPile.flipTopCard();
					currentCard.toggleSelect();
					currentCard = null;
					firstClick = true;
				}
			} else {
				currentCard.toggleSelect();
				// currentCard = null;
				firstClick = true;
			}
			return true;
		}
		return false;
	}

	private void secondClickAceCheck(AcePile a, Location loc) {
		if (a.gotClicked(loc)) {
			if ((a.isEmpty() && currentCard.getValue() == 0) || (a.getTopCard().getValue() == currentCard.getValue() - 1
					&& a.getTopCard().getSuit() == currentCard.getSuit())) {
				a.addCard(currentPile.deal());
				currentPile.flipTopCard();
				currentCard.toggleSelect();
				currentCard = null;
				firstClick = true;
			}
		} else {
			// currentCard.toggleSelect();
			// currentCard = null;
			// firstClick = true;
		}
	}

	@Override
	// this update will be called each time the timer in the KlondikeGame
	// goes off. This will be convenient for animating.
	public void update(ActionEvent a) {
	}
}
