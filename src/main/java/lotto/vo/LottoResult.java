package lotto.vo;

public class LottoResult {
    private int matchCount;
    private boolean bonusNumberMatch;

    public LottoResult(int matchCount, boolean bonusNumberMatch) {
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
