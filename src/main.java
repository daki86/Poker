import java.util.Collections;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards ds = new DeckOfCards();
		TexasHoldem tx = new TexasHoldem();
		Hand h = new Hand();		
		ds.shuffleDeck();
		
		
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		
		System.out.println(h.getHandOfCards().toString()+"\n");
//		tx.onePair(h.getHandOfCards());
//		tx.twoPair(h.getHandOfCards());
//		tx.highCard(h.getHandOfCards());
//		tx.threeOfAKind(h.getHandOfCards());
//		tx.fourOfAKind(h.getHandOfCards());
//		tx.straight(h.getHandOfCards());
		tx.flush(h.getHandOfCards());
//		tx.fullHouse(h.getHandOfCards());
//		tx.straightFlush(h.getHandOfCards());
		//System.out.println(ds.drawACard().toString());
	}

}
