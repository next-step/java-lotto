package model;

public enum Placement {
    SIX_MATCHES(6, 2_000_000_000),
    FIVE_MATCHES(5, 1_500_000),
    FOUR_MATCHES(4, 50_000),
    THREE_MATCHES(3, 5_000),
    MISS(0, 0);

    private final int matchingCount;
    private final int prizeMoney;

    Placement(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int prizeMoney() {
        return prizeMoney;
    }

}
