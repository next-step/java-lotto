package lotto.domain;

import java.util.Objects;

public class LottoResult {

    private final int matchCount;
    private final boolean isMatchBonus;

    public LottoResult(int matchCount, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean isMatchBonus() {
        return this.isMatchBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult that = (LottoResult) o;
        return matchCount == that.matchCount && isMatchBonus == that.isMatchBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isMatchBonus);
    }
}
