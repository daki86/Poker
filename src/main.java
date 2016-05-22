import java.util.Collections;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeckOfCards ds = new DeckOfCards();
		TexasHoldem tx = new TexasHoldem();
		Hand h = new Hand();		
		ds.shuffleDeck();
		
//		Card c1 = new Card(2,"SPADE");
//		Card c2 = new Card(13,"CLUB");
//		Card c3 = new Card(4,"DIAMOND");
//		Card c4 = new Card(3,"DIAMOND");
//		Card c5 = new Card(6,"DIAMOND");
//		Card c6 = new Card(14,"SPADE");
//		Card c7 = new Card(5,"DIAMOND");
		
//		h.addCardTohandOfCards(c1);
//		h.addCardTohandOfCards(c2);
//		h.addCardTohandOfCards(c3);
//		h.addCardTohandOfCards(c4);
//		h.addCardTohandOfCards(c5);
//		h.addCardTohandOfCards(c6);
//		h.addCardTohandOfCards(c7);
		
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());
		h.addCardTohandOfCards(ds.drawACard());


		for(int i=0; i<h.getHandOfCards().size(); i++)
		System.out.println(h.getHandOfCards().get(i));

		System.out.println();
		tx.checkForCombination(h);
		
		//System.out.println(ds.drawACard().toString());
	}

}
