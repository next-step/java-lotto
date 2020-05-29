package lotto_step2.model;

public enum PrizeMachine {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ZERO(0, 0);

    private int matchCount;
    private int prize;

    PrizeMachine(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getLottoPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static PrizeMachine matchPrize(int matchCount) {
        for (PrizeMachine prize : PrizeMachine.values()) {
            if (prize.matchCount == matchCount) {
                return prize;
            }
        }
        return PrizeMachine.ZERO;
    }
}
