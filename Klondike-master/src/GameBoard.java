import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GameBoard implements Drawable, Updateable {
	private Deck deck;
	private DrawPile drawPile = new DrawPile(100, 100);
	private PlayPile playPile1 = new PlayPile(200+100*0,300);
	private PlayPile playPile2 = new PlayPile(200+100*1,300);
	private PlayPile playPile3 = new PlayPile(200+100*2,300);
	private PlayPile playPile4 = new PlayPile(200+100*3,300);
	private PlayPile playPile5 = new PlayPile(200+100*4,300);
	private PlayPile playPile6 = new PlayPile(200+100*5,300);
	private PlayPile playPile7 = new PlayPile(200+100*6,300);
	private AcePile clubs = new AcePile(200+100*3, 100);
	private AcePile spades = new AcePile(200+100*4, 100);
	private AcePile hearts = new AcePile(200+100*5, 100);
	private AcePile diamonds = new AcePile(200+100*6, 100);

	private boolean firstClick=false;
	private int numdraws=0;
	public static final int OFFSET_X = 40, OFFSET_Y = 20;

	public GameBoard() {
		deck = new Deck();
		deck.shuffle();
		playPile1.addPlayCard(deck.deal());
		for(int i=0;i<2;i++)
			playPile2.addPlayCard(deck.deal());
		for(int i=0;i<3;i++)
			playPile3.addPlayCard(deck.deal());
		for(int i=0;i<4;i++)
			playPile4.addPlayCard(deck.deal());
		for(int i=0;i<5;i++)
			playPile5.addPlayCard(deck.deal());
		for(int i=0;i<6;i++)
			playPile6.addPlayCard(deck.deal());
		for(int i=0;i<7;i++)
			playPile7.addPlayCard(deck.deal());
	}

	/** @param g Graphics context onto which all Objects in the game
	 * draw themselves.  This should NOT change the Objects
	 */
	public void draw(Graphics g) {
		numdraws++;
		g.setColor(new Color(81, 163, 176));
		g.fillRect(0, 0, 3000, 2000);
		// try {
		// 	g.drawImage(ImageIO.read(new File("images/cards/casinoFelt.jpeg")), 0, 0, null);
		// } catch (IOException e) {
		// 	// TODO Auto-generated catch block
		// 	e.printStackTrace();
		//}

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
		System.out.println(numdraws); //TESTING
	}

	/**
	 * This method is called by the game when a click has been made 
	 * on the panel.  Must determine if the click makes sense (is it 
	 * a valid location, If it is the first click, then note it and
	 * the next click will attempt a move (maybe).
	 * @param me
	 */
	public void justClicked(MouseEvent me) {
		Point p = me.getPoint();
		System.out.println("You just clicked "+p);
		Location clickLoc = new Location(p.getX(), p.getY());
		if(firstClick){
			firstClick(clickLoc);	
		}
		else{
			secondClick(clickLoc);
		}
	}
	
	private void firstClick(Location loc){
		//TODO
	}

	private void secondClick(Location loc){
		//TODO
	}

	@Override
	// this update will be called each time the timer in the KlondikeGame
	// goes off.  This will be convenient for animating.
	public void update(ActionEvent a) {
		
	}
}
