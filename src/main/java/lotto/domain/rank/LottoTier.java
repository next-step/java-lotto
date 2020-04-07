package lotto.domain.rank;

import java.util.Objects;

public class LottoTier {
    private final int matchCount;
    private final boolean bonus;

    private LottoTier(int matchCount, boolean bonus) {
        this.matchCount = matchCount;
        this.bonus = bonus;
    }

    public static LottoTier of(int matchCount, boolean bonus) {
        return new LottoTier(matchCount, bonus);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTier)) return false;
        LottoTier lottoTier = (LottoTier) o;
        return getMatchCount() == lottoTier.getMatchCount() &&
                isBonus() == lottoTier.isBonus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchCount(), isBonus());
    }
}
