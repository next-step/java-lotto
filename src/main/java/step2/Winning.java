package step2;

public enum Winning {
    FIRST(6, 2000000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;
    Winning(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }
    public int getPrize() {
        return prize;
    }
    public static Winning valueOf(int matchCount) {
        for (Winning winning : values()) {
            if (winning.matchCount == matchCount) {
                return winning;
            }
        }
        return NONE;
    }
}
