package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private int matchingCount;
    private int money;

    Prize(int matchingCount, int money) {
        this.matchingCount = matchingCount;
        this.money = money;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getMoney() {
        return money;
    }

    public static Prize valueOf(int matchingCount) {
        for (Prize prize : Prize.values()) {
            if (prize.matchingCount == matchingCount) {
                return prize;
            }
        }

        throw new IllegalArgumentException();
    }
}
