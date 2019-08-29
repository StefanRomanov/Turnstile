package domain;

public class Turnstile {

    private TurnstileState state;

    public Turnstile() {
        this.setState(TurnstileState.Locked);
    }

    public boolean putCoin() {

        if(this.getState() == TurnstileState.Paid || this.getState() == TurnstileState.Open){
            return false;
        }

        this.setState(this.getState().coin());
        return true;
    }

    public boolean canPass() {

        if(this.getState() == TurnstileState.Locked){
            return false;
        }

        this.setState(this.getState().pass());
        return true;
    }

    public void key() {
        this.setState(this.state.key());
    }

    public TurnstileState getState() {
        return state;
    }

    private void setState(TurnstileState newState) {
        this.state = newState;
    }
}
