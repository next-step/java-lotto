package lotto.domain.statistics;

import java.util.Objects;

public final class LottoMatchKey {

    private final boolean isBonus;
    private final int matchCount;

    public LottoMatchKey(final boolean isBonus, final int matchCount) {
        this.isBonus = isBonus;
        this.matchCount = matchCount;
    }

    public boolean getIsBonus() {
        return isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoMatchKey that = (LottoMatchKey) o;
        return isBonus == that.isBonus && matchCount == that.matchCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBonus, matchCount);
    }

}
