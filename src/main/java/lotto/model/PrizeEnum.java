package lotto.model;

public enum PrizeEnum {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5.5, 30000000),
    SIX(6, 2000000000),
    FAIL(0, 0);

    private double match;
    private int prize;

    PrizeEnum(double match, int prize) {
        this.match = match;
        this.prize = prize;
    }

    public double getMatch() {
        return match;
    }

    public int getPrize() {
        return prize;
    }
}
