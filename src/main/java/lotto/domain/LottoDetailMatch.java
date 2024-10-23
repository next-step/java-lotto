package lotto.domain;

public class LottoDetailMatch {
    private final int matchCount;
    private final boolean matchBonus;

    public LottoDetailMatch(int matchCount, boolean matchBonus) {
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
