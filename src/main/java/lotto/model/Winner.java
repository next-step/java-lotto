package lotto.model;

public class Winner {

    private int prize;
    private int matchingCount;

    public Winner(int prize, int matchingCount){
        this.prize = prize;
        this.matchingCount = matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
