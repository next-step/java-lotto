package lotto.constant;

public enum LottoPrize {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private final int match;
    private final int prize;

    LottoPrize(int match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }
}
