package lotto.domain;

public enum LottoReward {
    first(6,2000000000),
    second(5,1500000),
    third(4,50000),
    fourth(3,5000);

    private final int matchCount;
    private final int prize;

    LottoReward(final int matchCount, final int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
}
