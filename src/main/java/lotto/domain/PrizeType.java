package lotto.domain;

public enum PrizeType {
    FIRST_PRIZE(6, 2000000000),

    SECOND_PRIZE(5, 1500000),

    THIRD_PRIZE(4, 50000),

    FOURTH_PRIZE(3, 5000),

    NOT_MATCHING(0, 0);

    private final int numberOfMatching;
    private final long prize;

    PrizeType(int numberOfMatching, long prize) {
        this.numberOfMatching = numberOfMatching;
        this.prize = prize;
    }

    public int numberOfMatching() {
        return numberOfMatching;
    }

    public long prize() {
        return prize;
    }
}