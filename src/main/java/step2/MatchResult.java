package step2;

import java.util.Objects;

public class MatchResult {
    private static final int MIN = 0;
    private static final int MAX = 6;

    private long value;
    private boolean bonusMatched;

    public MatchResult(long value, boolean bonus) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("Invalid MatchCount valeu");
        }
        this.value = value;
        this.bonusMatched = bonus;
    }

    public long getValue() {
        return value;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public boolean isSame(WinResult winResult) {
        return this.value == winResult.getCountOfMatch()
                && this.bonusMatched == winResult.isBonusMatch();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return value == that.value &&
                bonusMatched == that.bonusMatched;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, bonusMatched);
    }
}
