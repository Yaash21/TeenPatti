package cardDao;


/*
 * Card Object represents a single card with value and suit.
 * A card is equal when value matches (Ignoring Suit for now)
 * Implements Comparable for sort
 * 
 */
public class Card implements Comparable<Card> {

	private int value;
	private String color;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Card(int value, String color) {
		super();
		this.value = value;
		this.color = color;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Card card = (Card) obj;
		return value == card.getValue() && color.equals(card.getColor());
	}

	@Override
	public String toString() {
		return "[" + value + "," + color + "]";
	}

	@Override
	public int compareTo(Card o) {
		if(this.value!=o.value) {
			return this.value-o.value;
		}
		return 0;
	}

}
