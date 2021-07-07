package cardFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cardConstants.Constants;
import cardDao.Card;
import cardDao.PlayerCard;

public class TieBreaker {
	
	/*
	 * In Case of multiple winners, pick up random cards 
	 * from the remaining deck of cards.
	 * Highest card will be the winner.
	 * Choosing the single winner from winner player list
	 */

	public PlayerCard processDrawResult(List<PlayerCard> winnerDrawList, CardDistribution carddistribute) {
		if (winnerDrawList.size() == 1) {
			return winnerDrawList.get(0);
		} else {

			Map<Integer, Map<PlayerCard, Card>> tieBreakerMap = new HashMap<>();
			for (PlayerCard player : winnerDrawList) {
				Card drawNewCard = carddistribute.cardDistribute();
				Map<PlayerCard, Card> playerDrawCard = new HashMap<>();
				playerDrawCard.put(player, drawNewCard);
				if(drawNewCard.getValue()==1) {
					tieBreakerMap.put(Constants.ACECARD, playerDrawCard);
				}else {
					tieBreakerMap.put(drawNewCard.getValue(), playerDrawCard);
				}
				
			}
			int highCardValue = 2;
			for (int cardValue : tieBreakerMap.keySet()) {
				if (cardValue == 1) {
					highCardValue = Constants.ACECARD;
				} else if (cardValue > highCardValue) {
					highCardValue = cardValue;
				}
			}
			winnerDrawList = new ArrayList<>();
			for (PlayerCard player : tieBreakerMap.get(highCardValue).keySet()) {
				winnerDrawList.add(player);
			}
			return processDrawResult(winnerDrawList, carddistribute);

		}

	}
}
