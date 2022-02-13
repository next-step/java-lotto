package lotto.domain;

public class WinningResult {

    private int matchCount;
    private int hasBonus;

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
