package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private int havingCounts;
    private int money;

    Prize(int havingCounts, int money) {
        this.havingCounts = havingCounts;
        this.money = money;
    }

    public int getHavingCounts() {
        return havingCounts;
    }

    public int getMoney() {
        return money;
    }

    public static Prize havingCountsOf(int hasWinningNumberCounts) {
        for (Prize prize : Prize.values()) {
            if (prize.havingCounts == hasWinningNumberCounts) {
                return prize;
            }
        }

        throw new IllegalArgumentException();
    }
}
