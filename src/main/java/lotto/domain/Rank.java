package lotto.domain;

public class Rank {

    private final int matchingNumberCount;
    private int matchingLottosCount;

    public Rank(int matchingNumberCount) {
        this.matchingNumberCount = matchingNumberCount;
        this.matchingLottosCount = 0;
    }

    public Rank(int matchingNumberCount, int matchingLottosCount) {
        this.matchingNumberCount = matchingNumberCount;
        this.matchingLottosCount = matchingLottosCount;
    }

    public boolean isMatching(int matchingCount) {
        return matchingNumberCount == matchingCount;
    }

    public void addMatchingLottosCount() {
        matchingLottosCount++;
    }

    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }

    public int getMatchingLottosCount() {
        return matchingLottosCount;
    }
}
