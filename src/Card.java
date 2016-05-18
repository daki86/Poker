import java.awt.image.BufferedImage;

public class Card {

	private int value;
	private String suit;
	private BufferedImage cardImage;
	
	public Card(int value, String suit){
		
		this.suit = suit;
		this.value = value;	
	}
	
	public int getValue(){
		return this.value;
	}
	
	public String getSuit(){
		return this.suit;
	}
	
	public String toString(){
		String card;
		card = this.suit +" "+this.value;
		
		return card; 
	}
}
