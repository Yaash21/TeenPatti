package cardFunctions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import cardConstants.Constants;
import cardDao.Card;
import cardDao.PlayerCard;


public class CardDistribution {
	private Map<String, List<Integer>> cardsDeck;

	public Map<String, List<Integer>> getCardsDeck() {
		return cardsDeck;
	}

	public CardDistribution() {
		deckShuffle();
		
	}
	
	
	/*
	 * For deck re-suffle and preparing deck in form Map<Suits,List<Values>>
	 */
	private void deckShuffle(){
		cardsDeck = new HashMap<>();
		for (String suit : Constants.SUITS) {
			cardsDeck.put(suit, new ArrayList<>(Arrays.asList(Constants.VALUES)));
		}
	}

	/*
	 * Distributing the cards randomly to players
	 */
	public List<PlayerCard> distribution(int numberOfPlayers) {
		List<PlayerCard> playerList = new ArrayList<>();
		for (int i = 1; i <= numberOfPlayers; i++) {
			Card card1 = cardDistribute();
			Card card2 = cardDistribute();
			Card card3 = cardDistribute();
			PlayerCard playerCard = new PlayerCard(i, card1, card2, card3);
			playerList.add(playerCard);
		}
		return playerList;

	}
	/*
	 * Get a random card from the deck and subsequently removing from the existing deck
	 * If there is only one value left in the deck, then returning the last card and
	 * subsequently removing the suit form map
	 * 
	 */
	public Card cardDistribute() {
		Random rn = new Random();
		Object[] suits =  cardsDeck.keySet().toArray();
		String cardColor;
		List<Integer> cardValueList;
		if(suits.length>1) {
			 cardColor = (String)suits[rn.nextInt(suits.length -1)];
		}else {
			 cardColor = (String)suits[0];
		}
		cardValueList = cardsDeck.get(cardColor);
		int cardIndex;
		int cardValue;
		if (cardValueList.size() > 1) {
			cardIndex = rn.nextInt(cardValueList.size() - 1);
			cardValue = cardValueList.get(cardIndex);
			cardValueList.remove(cardIndex);
		}
		else {
			cardIndex=0;
			cardValue = cardValueList.get(cardIndex);
			cardsDeck.remove(cardColor);
		}
		
//		DeckShuffle for edge case
		if(suits.length==1 && cardValueList.size()==0 ){
			deckShuffle();
		}
		
		return new Card(cardValue, cardColor);
	}

}
