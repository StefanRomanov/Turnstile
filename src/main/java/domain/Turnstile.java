package domain;

import domain.svm.TurnstileState;

public class Turnstile {

    private TurnstileState state;

    public Turnstile() {
        this.setState(TurnstileState.Locked);
    }

    public boolean putCoin() {
        this.setState(this.getState().coin());
        return this.getState().getSuccess();
    }

    public boolean canPass() {
        this.setState(this.getState().pass());
        return this.getState().getSuccess();
    }

    public void key() {
        this.setState(this.state.key());
    }

    public TurnstileState getState() {
        return this.state;
    }

    private void setState(TurnstileState newState) {
        this.state = newState;
    }
}
