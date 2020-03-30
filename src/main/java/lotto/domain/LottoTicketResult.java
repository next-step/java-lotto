package lotto.domain;

public class LottoTicketResult {
    private int matchCount;
    private boolean bonusMatch;

    public LottoTicketResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}