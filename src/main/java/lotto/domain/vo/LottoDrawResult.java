package lotto.domain.vo;

public class LottoDrawResult {
    private final int matchCount;
    private final boolean matchBonus;

    public LottoDrawResult(int matchCount, boolean matchBonus) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }
}
