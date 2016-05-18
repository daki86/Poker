
public enum CardSuit {
	SPADE(1), HEART(2), DIAMOND(3), CLUB(4);
	
	private final int value;
	
	private CardSuit(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
