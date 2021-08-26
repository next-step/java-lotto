package lotto.domain;

public enum Prize {
    PRIZE_1ST(0, 6),
    PRIZE_2ND(1, 5),
    PRIZE_3RD(2, 4),
    PRIZE_4TH(3, 3);

    private final int index;
    private final int matchingCount;

    Prize(int index, int matchingCount) {
        this.index = index;
        this.matchingCount = matchingCount;
    }

    public int index() {
        return index;
    }

    public int matchingCount() {
        return matchingCount;
    }
}
