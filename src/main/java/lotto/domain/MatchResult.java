package lotto.domain;

/**
 * 로또 번호 일치 개수를 나타내는 객체
 */
public class MatchResult {
    private final long count;
    private final boolean isBonusMatched;

    public MatchResult(long count, boolean isBonusMatched) {
        validate(count);
        this.count = count;
        this.isBonusMatched = isBonusMatched;
    }

    private void validate(long value) {
        if (value > 6 || value < 0) {
            throw new IllegalArgumentException("로또 번호 일치 개수는 0 이상 6 이하만 가능합니다.");
        }
    }

    public long count() {
        return count;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }
}
