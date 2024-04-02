package lotto.domain;

import java.util.Objects;

public class LottoRankKey {

    private int matchCount;
    private boolean isBonus;

    public LottoRankKey(int matchCount, boolean isBonus) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public static LottoRankKey of(int matchCount, boolean isBonus) {
        return new LottoRankKey(matchCount, isBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoRankKey that = (LottoRankKey) o;
        return matchCount == that.matchCount && isBonus == that.isBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, isBonus);
    }
}
