package lotto.domain;

public enum LottoMatchInformation {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int match;
    private final double prize;

    LottoMatchInformation(int match, double prize) {
        this.match = match;
        this.prize = prize;
    }

    public int getMatch() {
        return match;
    }

    public double getPrize() {
        return prize;
    }
}
