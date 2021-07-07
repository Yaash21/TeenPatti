package testPackage;

import org.junit.Assert;
import org.junit.Test;

import cardConstants.Constants;
import cardDao.Card;
import cardDao.PlayerCard;

public class TestPlayerCard {

	@Test
	public void TestpriorityAndHighCardSettingForTrail() {
//		Prepare and Test
		PlayerCard playerCard = new PlayerCard(1, new Card(7, "heart"), new Card(7, "diamond"), new Card(7, "club"));
//		Assert
		Assert.assertEquals(playerCard.getPriority(), Constants.TRAIL);
		Assert.assertEquals(playerCard.getHighCardvalue(), 7);

	}

	@Test
	public void TestpriorityAndHighCardSettingForSequence() {
//		Prepare and Test
		PlayerCard playerCard = new PlayerCard(1, new Card(7, "heart"), new Card(8, "diamond"), new Card(9, "heart"));
//		Assert
		Assert.assertEquals(playerCard.getPriority(), Constants.SEQUENCE);
		Assert.assertEquals(playerCard.getHighCardvalue(), 9);

	}

	@Test
	public void TestpriorityAndHighCardSettingForPair() {
//		Prepare and Test
		PlayerCard playerCard = new PlayerCard(1, new Card(7, "heart"), new Card(7, "diamond"), new Card(10, "club"));
//		Assert
		Assert.assertEquals(playerCard.getPriority(), Constants.PAIR);
		Assert.assertEquals(playerCard.getHighCardvalue(), 7);

	}

	@Test
	public void TestpriorityAndHighCardSettingForHighCard() {
//		Prepare and Test
		PlayerCard playerCard = new PlayerCard(1, new Card(7, "heart"), new Card(10, "diamond"), new Card(1, "club"));
//		Assert
		Assert.assertEquals(playerCard.getPriority(), Constants.HIGHCARD);
		Assert.assertEquals(playerCard.getHighCardvalue(), Constants.ACECARD);

	}

}
