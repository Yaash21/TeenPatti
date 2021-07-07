package cardFunctions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cardDao.PlayerCard;

public class ShowOfHands {

	
	/*
	 * Putting all the Player cards in a Map<PriorityValue,List<PlayerCard>>
	 * Multiple players can have same priority
	 */
	public Map<Integer, List<PlayerCard>> allHandsMap(List<PlayerCard> playerCardDistributionList) {
		Map<Integer, List<PlayerCard>> playerCardPriorityMap = new HashMap<>();
		for (PlayerCard playerCard : playerCardDistributionList) {
			int priority = playerCard.getPriority();
			if (playerCardPriorityMap.get(priority) != null) {
				playerCardPriorityMap.get(priority).add(playerCard);
			} else {
				List<PlayerCard> playerList = new ArrayList<>();
				playerList.add(playerCard);
				playerCardPriorityMap.put(priority, playerList);
			}
		}
		return playerCardPriorityMap;
	}
	
	/*
	 * Selecting the max priority in  Map<PriorityValue,List<PlayerCard>>
	 * and then selecting the max highCard among max priority
	 * and declaring the winner players.
	 */

	public List<PlayerCard> winnerPlayerList(Map<Integer, List<PlayerCard>> playerCardPriorityMap) {

		int highestWinningPriority = 0;
		for (int key : playerCardPriorityMap.keySet()) {
			if (key > highestWinningPriority) {
				highestWinningPriority = key;
			}
		}
		List<PlayerCard> winningPlayerList = playerCardPriorityMap.get(highestWinningPriority);
		if(winningPlayerList.size()>1) {
		int highValueCards = winningPlayerList.get(0).getHighCardvalue();
		for(int i=1;i<winningPlayerList.size();i++) {
			if(winningPlayerList.get(i).getHighCardvalue()<highValueCards) {
				winningPlayerList.remove(i);
				i--;
			}else if(winningPlayerList.get(i).getHighCardvalue()>highValueCards) {
				highValueCards=winningPlayerList.get(i).getHighCardvalue();
				winningPlayerList.remove(i-1);
				i--;
			}	
		}
		return winningPlayerList;
		}else {
			return winningPlayerList;
		}
		

	}

}
