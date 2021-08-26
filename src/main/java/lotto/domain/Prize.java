package lotto.domain;

public enum Prize {
    PRIZE_1ST(0, 6, 2000000000),
    PRIZE_2ND(1, 5, 1500000),
    PRIZE_3RD(2, 4, 50000),
    PRIZE_4TH(3, 3, 5000);

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

    int totalMoney(int count) {
        return money * count;
    }
}
