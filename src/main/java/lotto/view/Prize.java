package lotto.view;

public enum Prize {
    FIRST(1, 2000000000),
    SECOND(2, 1500000),
    THIRD(3, 50000),
    FOURTH(4, 5000);

    private final int ranking;
    private final int prize;

    Prize(int ranking, int prize) {
        this.ranking = ranking;
        this.prize = prize;
    }

    public static int getPrizeByRanking(int ranking) {
        for (Prize prize : Prize.values()) {
            if (prize.ranking == ranking) {
                return prize.prize;
            }
        }
        throw new IllegalArgumentException("Invalid ranking value: " + ranking);
    }

}
