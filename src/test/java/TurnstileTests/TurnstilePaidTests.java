package TurnstileTests;

import domain.Turnstile;
import domain.svm.TurnstileState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstilePaidTests {
    private Turnstile turnstile;

    @Before
    public void prepare(){
        this.turnstile = new Turnstile();
        turnstile.putCoin();
    }

    @Test
    public void testSetup(){
        Assert.assertEquals("Turnstile should be in Paid state", TurnstileState.Paid, this.turnstile.getState());
    }

    @Test
    public void paidStateInsertCoin(){
        Assert.assertFalse("Putting coin when in state Paid should return False", this.turnstile.putCoin());
        Assert.assertEquals("Putting coin when in state Paid should should not change the state", TurnstileState.Paid ,this.turnstile.getState());
    }

    @Test
    public void paidStateApplyKey(){
        this.turnstile.key();
        Assert.assertEquals("Using key when in state Paid should change the state to Open", TurnstileState.Open ,this.turnstile.getState());
    }

    @Test
    public void paidStateAttemptPass(){
        Assert.assertTrue("Trying to pass when in state Paid should return True", this.turnstile.canPass());
        Assert.assertEquals("Passing when in state Paid should change the state to Locked", TurnstileState.Locked, this.turnstile.getState());
    }

    @Test
    public void multiplePassesInPaidStateTest(){
        this.turnstile.canPass();

        Assert.assertFalse("In Paid state only one pass should be allowed and the second attempt should return False", this.turnstile.canPass());
        Assert.assertEquals("After the first passes state should become Locked and additional passes should not change it", TurnstileState.Locked, this.turnstile.getState());
    }
}
