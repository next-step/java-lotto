package lotto.model;

import lotto.model.enumeration.Rank;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

    private final List<Lotto> lotteries;
    private final int purchaseAmount;

    public Lotteries(LottoFactory lottoFactory, int purchaseAmount) {
        this.lotteries = lottoFactory.create(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getLottoCount() {
        return lotteries.size();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public Map<Rank, Long> getLotteriesRank(List<LottoNumber> lastWinLotto) {
        return lotteries.stream()
                .map(lotto -> lotto.getMatchCount(lastWinLotto))
                .map(Rank::valueOf)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public long getTotalWinningMoney(Map<Rank, Long> lotteriesRank) {
        return lotteriesRank.entrySet().stream()
                .mapToLong((rank) -> rank.getKey().getWinningMoney() * rank.getValue())
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotteries lotteries1 = (Lotteries) o;
        return Objects.equals(lotteries, lotteries1.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }
}
