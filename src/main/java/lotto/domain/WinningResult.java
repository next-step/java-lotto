package lotto.domain;

public class WinningResult {

    private final int matchCount;
    private final int hasBonus;

    public WinningResult(int matchCount, int hasBonus) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getHasBonus() {
        return hasBonus;
    }
}
