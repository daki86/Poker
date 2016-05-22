import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
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
		int value = 0;
		ArrayList<Card> temp = communityCard;
		
		for(Card c : hand.getHandOfCards()){
			temp.add(c);
		}
		
		if(straightRoyalFlush(temp)){
			System.out.println("Straight royal flush!");
			value = 9;
		}else if(straightFlush(temp)){
			System.out.println("Straight flush!");
			value = 8;
		}else if(fourOfAKind(temp)){
			System.out.println("Four of a kind!");
			value = 7;
		}else if(fullHouse(temp)){
			System.out.println("Full house!");
			value = 6;
		}else if(!flush(temp).equals("")){
			System.out.println("Flush!");
			value = 5;
		}else if(straight(temp) != 0){
			System.out.println("Straight!");
			value = 4;
		}else if(threeOfAKind(temp)){
			System.out.println("Three of a kind!");
			value = 3;
		}else if(twoPair(temp)){
			System.out.println("Two pair!");
			value = 2;
		}else if(onePair(temp)){
			System.out.println("One pair!");
			value = 1;
		}else{
			System.out.println("High card: "+highCard(temp));
		}
		
		temp.clear();
		
		return value;
	}

	public boolean straightRoyalFlush(ArrayList<Card> cards){
		boolean found = false;
		DeckOfCards temp = new DeckOfCards(cards);
		String suit = flush(cards);
		int value = straight(cards);
		int nextValue = value;
		int counter = 0;
		
		temp.sortDeck();
		
		if(value == 14 && suit != ""){
			for(Card c:temp.getDeck()){
				if(c.getSuit().equals(suit) && c.getValue() == nextValue){
					nextValue = nextValue-1;
					counter++;
				}
			}
		}
		
		if(counter >= 5){
			found = true;
		}
		
		return found;
	}
	
	public boolean straightFlush(ArrayList<Card> cards){
		boolean found = false;
		DeckOfCards temp = new DeckOfCards(cards);
		String suit = flush(cards);
		int value = straight(cards);
		int nextValue = value;
		int counter = 0;
		
		temp.sortDeck();
		
		if(suit != ""){
			for(Card c:temp.getDeck()){
				if(c.getSuit().equals(suit) && c.getValue() == nextValue){
					nextValue = nextValue-1;
					counter++;
				}
			}
		}
		
		if(counter >= 5){
			found = true;
		}
		
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
		
		return found;
	}
	
	public String flush(ArrayList<Card> cards){
		DeckOfCards temp = new DeckOfCards(cards);
		String suit = "";
		int counter = 0;
		
		temp.sortDeck();
		
		for(Card c1:temp.getDeck()){
			for(Card c2:temp.getDeck()){
				if(c1.getSuit().equals(c2.getSuit())){
					counter++;
					if(counter >= 5){
						suit = c1.getSuit();
						break;
					}
				}
			}
			counter = 0;
		}
		
		return suit;
	}
	
	public int straight(ArrayList<Card> cards){
		DeckOfCards temp = new DeckOfCards(cards);
		int nextValue = temp.getDeck().get(0).getValue();
		int highValue = 0;
		int counter = 0;
		
		temp.sortDeckByValue();	

		for(int i=0; i<temp.getDeck().size(); i++){
			nextValue = temp.getDeck().get(i).getValue();
			
			for(int x=0; x<temp.getDeck().size(); x++){
				if(nextValue == temp.getDeck().get(x).getValue()){
					if(highValue < nextValue){
						highValue = nextValue;
					}
					
					nextValue = nextValue-1;
					counter++;
				}
			}
			
			if(counter >= 5){
				break;
			}else{
				counter = 0;
				highValue = 0;
			}
		}
		
		return highValue;
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

		return found;
	}
	
	public Card highCard(ArrayList<Card> cards){
		int highValue = 0;
		Card highCard = new Card(0,"");
		
		for(Card c1:cards){
			if(c1.getValue() > highValue){
				highValue = c1.getValue();
				highCard.setSuit(c1.getSuit());
				highCard.setValue(c1.getValue());
			}
		}

		return highCard;
	}
}
