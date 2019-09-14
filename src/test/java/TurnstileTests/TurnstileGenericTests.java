package TurnstileTests;

import domain.Turnstile;
import domain.svm.TurnstileState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnstileGenericTests {
    private Turnstile turnstile;

    @Before
    public void prepare(){
        this.turnstile = new Turnstile();
    }

    @Test
    public void initializationStateTest(){
        Assert.assertEquals("Should be initialized in Locked state",TurnstileState.Locked, this.turnstile.getState());
    }

    @Test
    public void multipleKeyUseTest(){
        this.turnstile.key();
        Assert.assertEquals("Key should change the state from Locked to Open",TurnstileState.Open, this.turnstile.getState());
        this.turnstile.key();
        Assert.assertEquals("Key should change the state from Open to Locked",TurnstileState.Locked, this.turnstile.getState());
    }
}
