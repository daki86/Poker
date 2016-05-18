import java.util.ArrayList;
import java.util.List;

public class Hand {
	
	private Boolean showCard;
	private int handValue;
	private ArrayList<Card> handOfCards;
	
	public Hand(){
		handValue = 0;
		handOfCards = new ArrayList<Card>();
	}
	
	public void addCardTohandOfCards(Card card){
		handOfCards.add(card);
	}
	
	public void returnCardsFromhandOfCards(DeckOfCards deck){
		for(Card card:handOfCards){
			deck.returnCardToDeck(card);
		}
		handOfCards.clear();
	}
	
	public ArrayList<Card> getHandOfCards(){
		return handOfCards;
	}
	
	public void setShowCard(Boolean show){
		showCard = show;
	}
	
	public Boolean getShowCard(){
		return showCard;
	}
}
