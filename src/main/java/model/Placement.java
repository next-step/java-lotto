package model;

public class Placement {
    private final int matchingCount;
    private final int prizeMoney;


    public Placement(int matchingCount, int prizeMoney) {
        this.matchingCount = matchingCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
