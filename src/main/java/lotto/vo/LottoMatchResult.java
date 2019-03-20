package lotto.vo;

public class LottoMatchResult {
    private int matchCount;
    private boolean bonusNumberMatch;

    public LottoMatchResult(int matchCount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusNumberMatch() {
        return bonusNumberMatch;
    }
}
