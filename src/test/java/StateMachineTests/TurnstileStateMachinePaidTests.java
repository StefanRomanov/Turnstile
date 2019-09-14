package StateMachineTests;

import domain.svm.TurnstileState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstileStateMachinePaidTests {

    private TurnstileState state;

    @Before
    public void prepare(){
        this.state = TurnstileState.Paid;
    }


    @Test
    public void testPaidInsertCoin(){
        this.state = this.state.coin();

        Assert.assertEquals("In state Paid the coin method should not change the status", TurnstileState.Paid, this.state);
    }

    @Test
    public void testPaidAttemptPass(){
        this.state = this.state.pass();

        Assert.assertEquals("In state Paid the pass method should return Locked status", TurnstileState.Locked, this.state);
    }

    @Test
    public void testPaidApplyKey(){
        this.state = this.state.key();

        Assert.assertEquals("In state Paid the key method should return Open status", TurnstileState.Open, this.state);
    }
}
