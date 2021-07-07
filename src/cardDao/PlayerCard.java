package cardDao;

import java.util.Arrays;

import cardConstants.Constants;

/*
 * PlayerCard object represents cards for one player.
 * Each player has playerId, 3 cards, priority(Trail,Sequence,Pair,HighCard),HighCard
 * 
 */
public class PlayerCard {

	private int playerId;
	private Card[] cards;
	private int highCardvalue;
	private int priority;

	public int getHighCardvalue() {
		return highCardvalue;
	}

	public int getPlayerId() {
		return playerId;
	}

	public PlayerCard(int playerId, Card card1, Card card2, Card card3) {
		super();
		this.playerId = playerId;
		this.cards = new Card[3];
		this.cards[0] = card1;
		this.cards[1] = card2;
		this.cards[2] = card3;
		Arrays.sort(this.cards);
		this.priority = priorityAndHighCardSetting();
		
	}

	public Card[] getCards() {
		return cards;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "PlayerId:" + playerId + " ,Cards:" + cards[0] + "," + cards[1] + "," + cards[2]+" ,Priority:"+priority+" ,highCard:"+highCardvalue;
	}
	/*
	 * Setting the priority in terms of Trail,Sequence,Pair,HighCard
	 * Setting the High Card Value. 
	 * In case of Pair the High card will be the pair value.
	 * 
	 */
	private int priorityAndHighCardSetting() {
		
		if(cards[0].getValue() == 1 || cards[1].getValue() == 1 || cards[2].getValue() == 1) {
			highCardvalue=Constants.ACECARD;
		}else {
			highCardvalue = Math.max(cards[0].getValue(), Math.max(cards[1].getValue(), cards[2].getValue()));
		}
		if (cards[0].getValue() == cards[1].getValue() && cards[1].getValue() == cards[2].getValue()) {
			return Constants.TRAIL;
		} else if (cards[0].getValue() == cards[1].getValue() || cards[0].getValue() == cards[2].getValue()
				|| cards[1].getValue() == cards[2].getValue()) {
			if (cards[0].compareTo(cards[1]) == 0 || cards[0].compareTo(cards[2]) == 0) {
				highCardvalue = cards[0].getValue();
			} else {
				highCardvalue = cards[1].getValue();
			}
			if(highCardvalue==1) {
				highCardvalue=Constants.ACECARD;
			}
			return Constants.PAIR;
		} else if (cards[0].getValue() + 1 == cards[1].getValue() && cards[1].getValue() + 1 == cards[2].getValue()) {
			return Constants.SEQUENCE;
		} else {
			return Constants.HIGHCARD;
		}

	}
	

}
