package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    private int countOfMatch;
    private long money;

    Prize(int countOfMatch, int money) {
        this.countOfMatch = countOfMatch;
        this.money = money;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getMoney() {
        return money;
    }

    public static Prize valueOf(int matchingCount) {
        for (Prize prize : Prize.values()) {
            if (prize.countOfMatch == matchingCount) {
                return prize;
            }
        }

        throw new IllegalArgumentException("NOT EXISTS");
    }
}
