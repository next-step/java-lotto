package step3.domain;

import java.util.Objects;

/**
 * 맞춘 결과 비교
 */
public class MatchResult {
    private final int matchCount;
    private final boolean bonusMatched;

    public MatchResult(int matchCount, boolean bonusMatched) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
    }

    public boolean verifyMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public boolean isSecond() {
        return matchCount == 5 && bonusMatched;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        MatchResult that = (MatchResult)o;
        return matchCount == that.matchCount && bonusMatched == that.bonusMatched;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, bonusMatched);
    }
}
