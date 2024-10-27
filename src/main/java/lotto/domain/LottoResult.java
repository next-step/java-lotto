package lotto.domain;

public class LottoResult {
    private final int matchCount;
    private final boolean isBonus;

    public LottoResult(int matchCount, boolean isBonus) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
