package testPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import cardDao.Card;
import cardDao.PlayerCard;
import cardFunctions.ShowOfHands;

public class TestShowOfHands {

	@Test
	public void testAllHandsMap() {
//		Prepare
		PlayerCard player1 = new PlayerCard(1, new Card(7, "spade"), new Card(8, "diamond"), new Card(13, "spade"));
		PlayerCard player2 = new PlayerCard(2, new Card(7, "heart"), new Card(6, "diamond"), new Card(8, "club"));
		PlayerCard player3 = new PlayerCard(3, new Card(7, "club"), new Card(2, "diamond"), new Card(13, "diamond"));
		List<PlayerCard> playerCardList = new ArrayList<>();
		playerCardList.add(player1);
		playerCardList.add(player2);
		playerCardList.add(player3);
//		Preparing ExpectedResult
		Map<Integer, List<PlayerCard>> expectedMap = new HashMap<>();
		List<PlayerCard> firstList = new ArrayList<>();
		firstList.add(player1);
		firstList.add(player3);
		List<PlayerCard> secondList = new ArrayList<>();
		secondList.add(player2);
		expectedMap.put(0, firstList);
		expectedMap.put(2, secondList);
//		Test
		ShowOfHands showOfHands = new ShowOfHands();
		Map<Integer, List<PlayerCard>> actualMap = showOfHands.allHandsMap(playerCardList);
//		Assert
		Assert.assertEquals(actualMap, expectedMap);

	}

	@Test
	public void testWinnerPlayerList() {
//		Prepare
		PlayerCard player1 = new PlayerCard(1, new Card(7, "spade"), new Card(8, "diamond"), new Card(13, "spade"));
		PlayerCard player2 = new PlayerCard(2, new Card(7, "heart"), new Card(6, "diamond"), new Card(8, "club"));
		PlayerCard player3 = new PlayerCard(3, new Card(7, "club"), new Card(2, "diamond"), new Card(13, "diamond"));
		Map<Integer, List<PlayerCard>> allhandsMap = new HashMap<>();
		List<PlayerCard> firstList = new ArrayList<>();
		firstList.add(player1);
		firstList.add(player3);
		List<PlayerCard> secondList = new ArrayList<>();
		secondList.add(player2);
		allhandsMap.put(0, firstList);
		allhandsMap.put(2, secondList);
//		Preparing ExpectedResult
		List<PlayerCard> expectedWinnerList = new ArrayList<>();
		expectedWinnerList.add(player2);
//		Test
		ShowOfHands showOfHands = new ShowOfHands();
		List<PlayerCard> actualWinnerList = showOfHands.winnerPlayerList(allhandsMap);
//		Assert
		Assert.assertEquals(actualWinnerList, expectedWinnerList);

	}

}
