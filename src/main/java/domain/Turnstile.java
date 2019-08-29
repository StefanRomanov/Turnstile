package domain;

public class Turnstile {

    private TurnstileState state;

    public Turnstile() {
        this.setState(TurnstileState.Locked);
    }

    public boolean putCoin() {

        //Inserting coin when in Paid and Open states not allowed.
        if(this.getState() == TurnstileState.Paid || this.getState() == TurnstileState.Open){
            return false;
        }

        //Generating next state
        this.setState(this.getState().coin());
        return true;
    }

    public boolean canPass() {

        //Passing through the gate when it is in status Locked is not allowed.
        if(this.getState() == TurnstileState.Locked){
            return false;
        }

        //Generating next state
        this.setState(this.getState().pass());
        return true;
    }

    public void key() {

        //Generating next state
        this.setState(this.state.key());
    }

    public TurnstileState getState() {
        return this.state;
    }

    private void setState(TurnstileState newState) {
        this.state = newState;
    }
}
