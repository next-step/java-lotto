package lotto.domain.winning;

public class WinningNumberResult {

    private final int matchCount;

    private final boolean isBonusNumberMatch;

    public WinningNumberResult(int matchCount, boolean isBonusNumberMatch) {
        this.matchCount = matchCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusGrade() {
        return matchCount == 5 && isBonusNumberMatch == true;
    }
}
