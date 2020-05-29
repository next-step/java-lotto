package lotto_step2.model;

public class Prize {

    private PrizeMachine prize;

    public Prize(PrizeMachine prize) {
        this.prize = prize;
    }

    public PrizeMachine getPrize() {
        return prize;
    }
}
