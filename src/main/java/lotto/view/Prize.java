package lotto.view;

public enum Prize {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Prize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static int calculatePrize(int matchCount) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount) {
                return prize.prize;
            }
        }
        return NONE.prize;
    }

}
