package domain;

import java.util.Objects;

public class LottoMatchResult {
    private final long matchCount;
    private boolean isMatchBonus;
    protected LottoMatchResult(long matchCount, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public static LottoMatchResult of(long matchCount, boolean isMatchBonus) {
        return new LottoMatchResult(matchCount, isMatchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchResult that = (LottoMatchResult) o;
        return matchCount == that.matchCount && isMatchBonus == that.isMatchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isMatchBonus);
    }
}
