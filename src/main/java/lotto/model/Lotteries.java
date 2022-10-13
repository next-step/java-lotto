package lotto.model;

import lotto.model.enumeration.Rank;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lotteries;
    private final int purchasedCount;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
        this.purchasedCount = getLottoCount();
    }

    public Lotteries(LottoFactory lottoFactory, int purchaseAmount) {
        this.purchasedCount = purchaseAmount / LOTTO_PRICE;
        this.lotteries = lottoFactory.create(this.purchasedCount);
    }

    public List<Lotto> getLotteries() {
        return lotteries;
    }

    public int getLottoCount() {
        return this.purchasedCount;
    }

    public Map<Rank, Long> getLotteriesRank(List<LottoNumber> lastWinLotto, int bonusBall) {
        return lotteries.stream()
                .map(lotto -> lotto.matchCount(lastWinLotto) + lotto.matchBonusBallCount(bonusBall))
                .map(Rank::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
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
