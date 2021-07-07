package testPackage;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import cardDao.Card;
import cardDao.PlayerCard;
import cardFunctions.CardDistribution;
import cardFunctions.TieBreaker;

public class TestTieBreaker {

	@Test
	public void testTieBreaker() {
//		Prepare
		PlayerCard player1 = new PlayerCard(1, new Card(7, "spade"), new Card(8, "diamond"), new Card(13, "spade"));
		PlayerCard player2 = new PlayerCard(2, new Card(7, "heart"), new Card(3, "diamond"), new Card(13, "club"));
		PlayerCard player3 = new PlayerCard(3, new Card(7, "club"), new Card(2, "diamond"), new Card(13, "diamond"));
		List<PlayerCard> winnerList = new ArrayList<>();
		winnerList.add(player1);
		winnerList.add(player2);
		winnerList.add(player3);
		CardDistribution cardDistribution = Mockito.mock(CardDistribution.class);
		Mockito.when(cardDistribution.cardDistribute()).thenReturn(new Card(4, "heart"))
				.thenReturn(new Card(1, "heart")).thenReturn(new Card(10, "heart"));
//		Test
		TieBreaker tieBreaker = new TieBreaker();
		PlayerCard exapectedWinnerpalyer = tieBreaker.processDrawResult(winnerList, cardDistribution);
//		Assert
		Assert.assertEquals(exapectedWinnerpalyer.getPlayerId(), 2);

	}

}
