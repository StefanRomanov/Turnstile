package TurnstileTests;

import domain.Turnstile;
import domain.svm.TurnstileState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstileLockedTests {
    private Turnstile turnstile;

    @Before
    public void prepare(){
        this.turnstile = new Turnstile();
    }

    @Test
    public void testSetup(){
        Assert.assertEquals("Turnstile should be in Locked state", TurnstileState.Locked, this.turnstile.getState());
    }

    @Test
    public void lockedStateInsertCoin(){
        Assert.assertTrue("Putting coin when in state Locked should return True",this.turnstile.putCoin());
        Assert.assertEquals("Putting coin when in state Locked should change the state to Paid", TurnstileState.Paid ,this.turnstile.getState());
    }

    @Test
    public void lockedStateAttemptPass(){

        Assert.assertFalse("Trying to pass when in state Locked should return False",this.turnstile.canPass());
        Assert.assertEquals("Trying to pass when in state Locked should not change the state", TurnstileState.Locked ,this.turnstile.getState());
    }

    @Test
    public void lockedStateApplyKey(){
        this.turnstile.key();
        Assert.assertEquals("Using key when in state Locked should change the state to Open", TurnstileState.Open ,this.turnstile.getState());
    }

    @Test
    public void multipleCoinsInsertedTest(){
        this.turnstile.putCoin();
        this.turnstile.putCoin();

        Assert.assertFalse("Multiple coin inserts should not be allowed and should return False", this.turnstile.putCoin());
        Assert.assertEquals("After multiple coin inserts state should remain Paid", TurnstileState.Paid, this.turnstile.getState());
    }
}
