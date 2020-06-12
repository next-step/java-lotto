package lotto.model;

public enum WinnerEnum {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    FAIL(0, 0);

    private int match;
    private int prize;

    WinnerEnum(int match, int prize) {
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
