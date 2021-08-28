package lotto.domain;

public enum Prize {
    FIRST(0, 6, 2000000000),
    SECOND(1, 5, 1500000),
    THIRD(2, 4, 50000),
    FOURTH(3, 3, 5000);

    private final int index;
    private final int matchingCount;
    private final int money;

    Prize(int index, int matchingCount, int prizeMoney) {
        this.index = index;
        this.matchingCount = matchingCount;
        this.money = prizeMoney;
    }

    public int index() {
        return index;
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
