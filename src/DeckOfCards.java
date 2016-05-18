
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

	public class DeckOfCards{
		private ArrayList<Card> deck;
		private CardSuit cardSuit;
		private CardValue cardValue;
		
		public DeckOfCards(){
			deck = new ArrayList<Card>();

			for(CardSuit suit: cardSuit.values()){	
				for(int cardValue=2; cardValue<=14; cardValue++){
					deck.add(new Card(cardValue,suit.toString()));
				}
			}
		}
		
		public DeckOfCards(ArrayList<Card> card){
			deck = new ArrayList<Card>();

			for(Card c: card){	
				deck.add(c);
			}
		}
		
		public void shuffleDeck(){
			Collections.shuffle(deck);
		}
		
		public void sortDeck(){	
			//deck.sort((p1, p2) -> p1.getSuit().compareTo(p2.getSuit()));	
			Collections.sort(deck, (lhs, rhs) -> {
			      if (lhs.getSuit().equals(rhs.getSuit()))
			        return  rhs.getValue() - lhs.getValue();
			      else
			        return rhs.getSuit().compareTo(lhs.getSuit());
			}); 
		}
		
		public void sortDeckByValue(){	
			//deck.sort((p1, p2) -> p1.getSuit().compareTo(p2.getSuit()));	
			Collections.sort(deck, (lhs, rhs) -> {
				return rhs.getValue() - lhs.getValue();
			}); 
		}
		
		public ArrayList<Card> getDeck(){
			return deck;
		}
		
		public Card drawACard(){
			Card card = deck.get(0);
			deck.remove(0);
			
			return card;
		}
		
		public void returnCardToDeck(Card card){
			deck.add(card);
		}
		
		public void print(){
			for(Card d: deck){
				switch(d.getValue()){
				case 2:
					System.out.println(d.getSuit()+" "+cardValue.TWO.toString());
					break;
				case 3:
					System.out.println(d.getSuit()+" "+cardValue.THREE.toString());
					break;
				case 4:
					System.out.println(d.getSuit()+" "+cardValue.FOUR.toString());
					break;
				case 5:
					System.out.println(d.getSuit()+" "+cardValue.FIVE.toString());
					break;
				case 6:
					System.out.println(d.getSuit()+" "+cardValue.SIX.toString());
					break;
				case 7:
					System.out.println(d.getSuit()+" "+cardValue.SEVEN.toString());
					break;
				case 8:
					System.out.println(d.getSuit()+" "+cardValue.EIGHT.toString());
					break;
				case 9:
					System.out.println(d.getSuit()+" "+cardValue.NINE.toString());
					break;
				case 10:
					System.out.println(d.getSuit()+" "+cardValue.TEN.toString());
					break;
				case 11:
					System.out.println(d.getSuit()+" "+cardValue.JACK.toString());
					break;
				case 12:
					System.out.println(d.getSuit()+" "+cardValue.QUEEN.toString());
					break;
				case 13:
					System.out.println(d.getSuit()+" "+cardValue.KING.toString());
					break;
				case 14:
					System.out.println(d.getSuit()+" "+cardValue.ACE.toString());
					break;
				}
			}
		}
	}
