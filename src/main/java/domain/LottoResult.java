package domain;

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
        return new LottoResult(countByRank, new Cash(lottos.totalPrice()));
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
