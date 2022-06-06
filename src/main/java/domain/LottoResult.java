package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class LottoResult {
    private final CountByRank countByRank;
    private final Cash cash;

    public LottoResult(CountByRank countByRank, Cash cash) {
        this.countByRank = countByRank;
        this.cash = cash;
    }

    public static LottoResult create(Winner winner, Lottos lottos) {
        CountByRank countByRank = CountByRank.create();
        for (Lotto lotto : lottos.toList()) {
            Rank rank = winner.match(lotto);
            countByRank = countByRank.increaseCount(rank);
        }
        return new LottoResult(countByRank, lottos.totalPrice());
    }

    public BigDecimal winningRate() {
        return countByRank.winningMoney().toBigDecimal().divide(cash.toBigDecimal(), 2, RoundingMode.HALF_UP);
    }

    public int count(Rank rank) {
        return countByRank.count(rank);
    }

    public boolean isGain() {
        return winningRate().compareTo(BigDecimal.ONE) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return countByRank.equals(that.countByRank) && cash.equals(that.cash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countByRank, cash);
    }
}
