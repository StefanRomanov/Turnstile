package domain.svm;

import domain.Turnstile;

public enum TurnstileState {
    Locked{
        public boolean getSuccess() {
            return this.success;
        }

        @Override
        public TurnstileState coin(){
            //State transition from Locked to Paid
            TurnstileState newState = TurnstileState.Paid;
            newState.success = true;
            return newState;
        }

        @Override
        public TurnstileState pass(){
            //State remains unchanged
            this.success = false;
            return this;
        }

        @Override
        public TurnstileState key(){
            //State transition from Locked to Open
            TurnstileState newState = TurnstileState.Open;
            newState.success = true;
            return newState;
        }
    },
    Paid{
        public boolean getSuccess() {
            return this.success;
        }
        @Override
        public TurnstileState coin(){
            //State remains unchanged
            this.success = false;
            return this;
        }

        @Override
        public TurnstileState pass(){
            //State transition from Paid to Locked
            TurnstileState newState = TurnstileState.Locked;
            newState.success = true;
            return newState;
        }

        @Override
        public TurnstileState key(){
            //State transition from Paid to Open
            TurnstileState newState = TurnstileState.Open;
            newState.success = true;
            return newState;
        }
    },
    Open{
        public boolean getSuccess() {
            return this.success;
        }
        @Override
        public TurnstileState coin(){
            //State remains unchanged
            this.success = false;
            return this;
        }

        @Override
        public TurnstileState pass(){
            //State remains unchanged
            this.success = true;
            return this;
        }

        @Override
        public TurnstileState key(){
            //State transition from Open to Locked
            TurnstileState newState = TurnstileState.Locked;
            newState.success = true;
            return newState;
        }
    };

    protected boolean success;
    public abstract boolean getSuccess();
    public abstract TurnstileState coin();
    public abstract TurnstileState pass();
    public abstract TurnstileState key();
}
