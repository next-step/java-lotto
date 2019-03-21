package lotto.domain;

public class WinningResult{
    private Prize prize;
    private int matchingCount;

    public WinningResult(Prize prize, int matchingCount) {
        this.prize = prize;
        this.matchingCount = matchingCount;
    }

    public Prize getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}