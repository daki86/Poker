import java.awt.image.BufferedImage;

public class Card {

	private int value;
	private CardValue cardValue;
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
	
	public void setValue(int value){
		this.value = value;
	}
	
	public void setSuit(String suit){
		this.suit = suit;
	}
	
	public String toString(){
		String card;
		
		switch (this.value){
		case 11:
			card = cardValue.JACK+" OF "+this.suit;
			break;
			
		case 12:
			card = cardValue.QUEEN+" OF "+this.suit;
			break;
			
		case 13:
			card = cardValue.KING+" OF "+this.suit;
			break;
			
		case 14:
			card = cardValue.ACE+" OF "+this.suit;
			break;
			
		default:
			card = this.value+" OF "+this.suit;
			break;
		}
		
		return card; 
	}
}
