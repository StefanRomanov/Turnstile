package StateMachineTests;

import domain.svm.TurnstileState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstileStateMachineLockedTests {

    private TurnstileState state;

    @Before
    public void prepare(){
        this.state = TurnstileState.Locked;
    }


    @Test
    public void testLockedInsertingCoin(){
        this.state = this.state.coin();

        Assert.assertEquals("In state Locked the coin method should return Paid status",TurnstileState.Paid, this.state);
    }

    @Test
    public void testLockedAttemptPass(){
        this.state = this.state.pass();

        Assert.assertEquals("In state Locked the pass method should not change the status",TurnstileState.Locked, this.state);
    }

    @Test
    public void testLockedApplyKey(){
        this.state = this.state.key();

        Assert.assertEquals("In state Locked the key method should return Open status", TurnstileState.Open, this.state);
    }

}
