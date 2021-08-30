package lotto.domain;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private final int matchingCount;
    private final int money;

    Prize( int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.money = prizeMoney;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int money() {
        return money;
    }

    int winningMoney(int count) {
        return money * count;
    }
}
