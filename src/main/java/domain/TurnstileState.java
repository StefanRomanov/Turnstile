package domain;

public enum TurnstileState {
    Locked{
        @Override
        public TurnstileState coin(){
            return TurnstileState.Paid;
        }

        @Override
        public TurnstileState pass(){
            return this;
        }

        @Override
        public TurnstileState key(){
            return TurnstileState.Open;
        }
    },
    Paid{
        @Override
        public TurnstileState coin(){
            return this;
        }

        @Override
        public TurnstileState pass(){
            return TurnstileState.Locked;
        }

        @Override
        public TurnstileState key(){
            return TurnstileState.Open;
        }
    },
    Open{
        @Override
        public TurnstileState coin(){
            return this;
        }

        @Override
        public TurnstileState pass(){
            return this;
        }

        @Override
        public TurnstileState key(){
            return TurnstileState.Locked;
        }
    };

    public abstract TurnstileState coin();
    public abstract TurnstileState pass();
    public abstract TurnstileState key();
}
