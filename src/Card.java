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
			card = this.suit +" "+cardValue.JACK;
			break;
			
		case 12:
			card = this.suit +" "+cardValue.QUEEN;
			break;
			
		case 13:
			card = this.suit +" "+cardValue.KING;
			break;
			
		case 14:
			card = this.suit +" "+cardValue.ACE;
			break;
			
		default:
			card = this.suit +" "+this.value;
			break;
		}
		
		return card; 
	}
}
