package model;

public class Placement {
    private final int matchingCount;
    private final int prize;


    public Placement(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int prize() {
        return prize;
    }
}
