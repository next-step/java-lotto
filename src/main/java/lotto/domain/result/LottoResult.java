package lotto.domain.result;

import lotto.vo.Money;

import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final List<LottoPrize> lottoStatistics;

    public LottoResult(List<LottoPrize> lottoPrizes) {
        this.lottoStatistics = lottoPrizes;
    }

    public int getNumberOfHitTickets(final LottoPrize lottoPrize) {
        return Math.toIntExact(lottoStatistics.stream()
                .filter(lottoStatistic -> lottoStatistic.equals(lottoPrize))
                .count());
    }

    public double getRateOfProfit(final Money expenditure) {
        Money totalProfit = calculateTotalReword();
        return totalProfit.calculateYield(expenditure);
    }

    private Money calculateTotalReword() {
        return lottoStatistics.stream()
                .map(LottoPrize::getReward)
                .reduce(new Money(0), Money::add);
    }

    public List<LottoPrize> getLottoStatistics() {
        return Collections.unmodifiableList(lottoStatistics);
    }
}
