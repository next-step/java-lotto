package lotto.domain;

public class LottoTicketResult {
    private static final int WINNING_MIN_COUNT = 3;

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

    public boolean isWinning() {
        return matchCount >= WINNING_MIN_COUNT;
    }
}