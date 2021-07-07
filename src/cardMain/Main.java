package cardMain;

import java.util.List;
import java.util.Map;

import cardDao.PlayerCard;
import cardFunctions.CardDistribution;
import cardFunctions.ShowOfHands;
import cardFunctions.TieBreaker;

public class Main {

	public static void main(String[] args) {
//		Deck Creation
		CardDistribution carddistribute = new CardDistribution();
//		Card Distribution
		List<PlayerCard> playerCardDistributionList = carddistribute.distribution(4);
		System.out.println("DistributionList");
		System.out.println(playerCardDistributionList);
		System.out.println("--------------------");
//		Preparing show of cards
		ShowOfHands showofhands = new ShowOfHands();
//		Creation of Player Cards map on show
		Map<Integer, List<PlayerCard>> playerCardPriorityMap = showofhands.allHandsMap(playerCardDistributionList);
//		Selecting winner Players
		List<PlayerCard> winnerPlayers = showofhands.winnerPlayerList(playerCardPriorityMap);
		System.out.println("Winner List");
		System.out.println(winnerPlayers);
		System.out.println("--------------------");
//		Preparing for Tie Breaker
		TieBreaker tieBreaker = new TieBreaker();
//		Choosing Winner
		PlayerCard winner = tieBreaker.processDrawResult(winnerPlayers, carddistribute);
		System.out.println("Winner");
		System.out.println(winner);
		System.out.println("--------------------");


	}

}
