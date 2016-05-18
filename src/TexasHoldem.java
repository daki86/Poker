import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class TexasHoldem {
	private DeckOfCards deck;
	private ArrayList<Card> communityCard;
	
	public TexasHoldem(){
		deck = new DeckOfCards();
		communityCard = new ArrayList();
		
		deck.shuffleDeck();
	}
	
	public void addCommunityCard(){
		communityCard.add(deck.drawACard());
	}
	
	public List getCommunityCard(){
		return communityCard;
	}

	public void returnCommunityCardToDeck(){
		for(Card c: communityCard){
			deck.returnCardToDeck(c);
		}
		communityCard.clear();
	}
	
	public int checkForCombination(Hand hand){
		int card1 = 0;
		int card2 = 1;
		int value = 0;
		ArrayList<Card> temp = communityCard;
		
		for(Card c : hand.getHandOfCards()){
			temp.add(c);
		}
		
	/*	if(){
			
		}else if(){
			
		}else if(){
			
		}else if(){
			
		}else if(){
			
		}else if(){
			
		}else if(){
			
		}else if(){
			
		}else if(){
			
		}*/
		
		//ONE PAIR
		//TWO PAIR
		//THREE OF A KIND
		//STRAIGHT
		//FLUSH
		//FULL HOUSE
		//FOUR OF A KIND
		//STRAIGHT FLUSH
		//ROYAL FLUSH
		
		temp.clear();
		
		return value;
	}

	public boolean straightFlush(ArrayList<Card> cards){
		boolean found = false;
		
		DeckOfCards temp = new DeckOfCards(cards);
		ArrayList<Card> holder = new ArrayList<Card>();
		
		int counter = 0;
		int [] value = new int[5];
		temp.sortDeck();
//		temp.print();
		
		int nextValue = temp.getDeck().get(0).getValue();
		
		
		
		if(counter >= 5){
			
			found = true;
		}
		
		System.out.println("Straight flush: "+found);
		return found;
	}
	
	public boolean fourOfAKind(ArrayList<Card> cards){
		boolean found = false;
		int counter = 0;
		int valueHolder = 0;
		
		for(Card c1:cards){
			for(Card c2:cards){
				if(!c1.getSuit().equals(c2.getSuit()) && c1.getValue() == c2.getValue() && valueHolder < c1.getValue()){
					counter++;
					if(counter == 3){
						valueHolder = c1.getValue();
						found = true;
					}
				}
			}
			counter = 0;
		}
		
//		System.out.println("Four of a kind: "+valueHolder);
		return found;
	}

	public boolean fullHouse(ArrayList<Card> cards){
		boolean found = false;
		DeckOfCards temp = new DeckOfCards(cards);
		
		int counter = 0;
		
		temp.sortDeckByValue();
		
		int value = temp.getDeck().get(0).getValue();
		
		for(Card c1:temp.getDeck()){
			for(Card c2:temp.getDeck()){
				if(c1.getValue() == c2.getValue()){
					counter++;
				}
			}
			if(counter == 2 && threeOfAKind(cards)){
				found = true;
			}
			counter = 0;
		}
		
//		System.out.println("Full house: "+found);
		return found;
	}
	
	public boolean flush(ArrayList<Card> cards){
		boolean found = false;
		DeckOfCards temp = new DeckOfCards(cards);
		
		int counter = 0;
		
		temp.sortDeck();
		temp.print();
		for(Card c1:temp.getDeck()){
			for(Card c2:temp.getDeck()){
				if(c1.getSuit().equals(c2.getSuit())){
					counter++;
					if(counter >= 5){
						found = true;
						break;
					}
				}
			}
			counter = 0;
		}
		
		System.out.println("Flush: "+found);
		return found;
	}
	
	public boolean straight(ArrayList<Card> cards){
		boolean found = false;
		DeckOfCards temp = new DeckOfCards(cards);
		
		int counter = 0;
		
		temp.sortDeckByValue();
		temp.print();
		int nextValue = temp.getDeck().get(0).getValue();
		
		for(Card c:temp.getDeck()){
			if(nextValue == c.getValue()){
				nextValue = 1-c.getValue();
				counter++;
			}
		}
		
		if(counter >= 5){
			found = true;
		}
		
		System.out.println("Straight: "+found);
		return found;
	}
	
	public boolean threeOfAKind(ArrayList<Card> cards){
		boolean found = false;
		int counter = 0;
		int valueHolder = 0;
		
		for(Card c1:cards){
			for(Card c2:cards){
				if(!c1.getSuit().equals(c2.getSuit()) && c1.getValue() == c2.getValue() && valueHolder < c1.getValue()){
					counter++;
					if(counter == 2){
						valueHolder = c1.getValue();
						found = true;
					}
				}
			}
			counter = 0;
		}
		
//		System.out.println("Three of a kind: "+valueHolder);
		return found;
	}
	
	public boolean twoPair(ArrayList<Card> cards){
		boolean found = false;
		int pair = 0;
		int pair2 = 0;
		
		for(Card c1:cards){
			for(Card c2:cards){
				if(!c1.getSuit().equals(c2.getSuit()) && c1.getValue() == c2.getValue() && pair < c1.getValue()){
					pair2 = pair;
					pair = c1.getValue();
				}
			}
		}
		if(pair2 != 0){
			found = true;
		}
		
//		System.out.println("Two pair: "+pair+" and "+pair2);
		return found;
	}
	
	public boolean onePair(ArrayList<Card> cards){
		boolean found = false;
		int pair = 0;
		
		for(Card c1:cards){
			for(Card c2:cards){
				if(!c1.getSuit().equals(c2.getSuit()) && c1.getValue() == c2.getValue() && pair < c1.getValue()){
					pair = c1.getValue();
					found = true;
				}
			}
		}
//		System.out.println("Highest pair: "+pair);
		return found;
	}
	
	public int highCard(ArrayList<Card> cards){
		int highCard = 0;
		
		for(Card c1:cards){
			if(c1.getValue() > highCard){
					highCard = c1.getValue();	
			}
		}
//		System.out.println("highCard: "+highCard);
		return highCard;
	}
}
