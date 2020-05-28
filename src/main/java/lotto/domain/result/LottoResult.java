package lotto.domain.result;

import lotto.vo.Money;

import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final List<LottoPrize> lottoStatistics;

    public LottoResult(final List<LottoPrize> lottoPrizes) {
        this.lottoStatistics = lottoPrizes;
    }

    public int countTicketsBy(final LottoPrize lottoPrize) {
        return Math.toIntExact(lottoStatistics.stream()
                .filter(lottoPrize::equals)
                .count());
    }

    public double getRateOfProfit(final Money expenditure) {
        return calculateTotalReword().calculateYield(expenditure);
    }

    private Money calculateTotalReword() {
        return lottoStatistics.stream()
                .map(LottoPrize::getReward)
                .reduce(Money.of(0), Money::add);
    }

    public List<LottoPrize> getLottoStatistics() {
        return Collections.unmodifiableList(lottoStatistics);
    }
}
