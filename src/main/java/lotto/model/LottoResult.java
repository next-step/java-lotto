package lotto.model;

public class LottoResult {

    private int prize;
    private int matchingCount;

    public LottoResult(int prize, int matchingCount){
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
