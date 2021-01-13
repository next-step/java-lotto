package lotto.domain;

public class LottoMatchResult {

    private final int matchCount;
    private final boolean hasBonusNumber;

    public LottoMatchResult(int matchCount, boolean hasBonusNumber) {
        validateMatchCount(matchCount);
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    private void validateMatchCount(int matchCount) {
        if (matchCount > 6 || matchCount < 0) {
            throw new IllegalArgumentException("Match Count의 개수가 잘못되었습니다.");
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
