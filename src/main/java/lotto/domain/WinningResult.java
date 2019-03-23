package lotto.domain;

public class WinningResult{
    private Prize prize;
    private int matchCount;

    public WinningResult(Prize prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}