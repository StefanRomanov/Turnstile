package domain;

public enum TurnstileState {
    Locked{
        @Override
        public TurnstileState coin(){
            //State transition from Locked to Paid
            return TurnstileState.Paid;
        }

        @Override
        public TurnstileState pass(){
            //State remains unchanged
            return this;
        }

        @Override
        public TurnstileState key(){
            //State transition from Locked to Open
            return TurnstileState.Open;
        }
    },
    Paid{
        @Override
        public TurnstileState coin(){
            //State remains unchanged
            return this;
        }

        @Override
        public TurnstileState pass(){
            //State transition from Paid to Locked
            return TurnstileState.Locked;
        }

        @Override
        public TurnstileState key(){
            //State transition from Paid to Open
            return TurnstileState.Open;
        }
    },
    Open{
        @Override
        public TurnstileState coin(){
            //State remains unchanged
            return this;
        }

        @Override
        public TurnstileState pass(){
            //State remains unchanged
            return this;
        }

        @Override
        public TurnstileState key(){
            //State transition from Open to Locked
            return TurnstileState.Locked;
        }
    };

    public abstract TurnstileState coin();
    public abstract TurnstileState pass();
    public abstract TurnstileState key();
}
