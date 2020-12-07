package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoPrize {
    private final Map<Rank, Long> result;

    LottoPrize(Map<Rank, Long> result) {
        this.result = result;
    }

    public static LottoPrize of(final List<Rank> ranks) {
        Map<Rank, Long> result = ranks.stream()
                .collect(Collectors.toMap(
                        rank -> rank,
                        rank -> LottoPrize.countRank(rank, ranks),
                        (existing, replacement) -> existing));

        return new LottoPrize(result);
    }

    public Money calculateProfit(Money originalMoney) {
        Money totalPrize = new Money(0L);

        for (Rank rank : this.result.keySet()) {
            Money totalPrizeOfRank = rank.multiplyPrize(this.result.get(rank));
            totalPrize = totalPrize.plus(totalPrizeOfRank);
        }

        return totalPrize.divide(originalMoney);
    }

    private static Long countRank(Rank target, List<Rank> ranks) {
        return ranks.stream()
                .filter(rank -> rank.equals(target))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPrize that = (LottoPrize) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
