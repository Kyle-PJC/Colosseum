package uk.ac.qub.eeecs.gage;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import uk.ac.qub.eeecs.game.TestClasses.CoinTossScreenForTesting;

@RunWith(MockitoJUnitRunner.class)
public class CoinTossScreenTest {

    @Mock
    private CoinTossScreenForTesting mCoinTossScreen;
    @Mock
    private Game mGame;

    @Before
    public void setUp() {
        when(mCoinTossScreen.getGame()).thenReturn(mGame);
        when(mCoinTossScreen.getName()).thenReturn("CoinTossScreen");
    }

    @Test
    public void screen_SetUpFully() {
        //This is a test on the constructor, to see when it is called,
        //is an instance of CoinTossScreen created or not -
        CoinTossScreenForTesting c1 = new CoinTossScreenForTesting(mGame, 0);

        assertNotNull(c1);
    }

    @Test
    public void screen_NameCorrect() {
        //This test is to ensure that the correct name is assigned to the new CoinTossScreen
        CoinTossScreenForTesting c1 = new CoinTossScreenForTesting(mGame, 0);

        String expectedResult = "CoinTossScreen";

        assertEquals(expectedResult, c1.getName());
    }

    @Test
    public void coinTossResult_SetCorrectly() {
        //This test is to ensure that whatever coin toss result is passed into the class, is assigned to
        //the mCoinTossResult variable within the CoinTossResult class
        CoinTossScreenForTesting c1 = new CoinTossScreenForTesting(mGame, 1);

        int expectedResult = 1;

        assertEquals(expectedResult, c1.getmCoinTossResult());
    }

    @Test
    public void checkMessage_CoinIsHeads() {
        //This test is to check that when the 'Heads' value (0) is passed in, is the
        //correct message passed in to be displayed on the CoinTossScreen:

        CoinTossScreenForTesting c1 = new CoinTossScreenForTesting(mGame, 0);

        //'chooseTextToDisplay' method is called:
        c1.chooseTextToDisplay();

        String expectedLine1 = "The coin landed on heads! You get to play first.";
        String expectedLine2 = "The other player draws 4 cards, and gets 1 additional mana.";

        assertEquals(expectedLine1, c1.getmCoinTossMsg1());
        assertEquals(expectedLine2, c1.getmCoinTossMsg2());
    }

    @Test
    public void checkMessage_CoinIsTails() {
        //This test is to check that when the 'Tails' value (1) is passed in, is the
        //correct message passed in to be displayed on the CoinTossScreen:
        CoinTossScreenForTesting c1 = new CoinTossScreenForTesting(mGame, 1);

        //'chooseTextToDisplay' method is called:
        c1.chooseTextToDisplay();

        String expectedLine1 = "The coin landed on tails! The enemy plays first.";
        String expectedLine2 = "You draw an extra card and additional mana for your troubles.";

        assertEquals(expectedLine1, c1.getmCoinTossMsg1());
        assertEquals(expectedLine2, c1.getmCoinTossMsg2());
    }

}
