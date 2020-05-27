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

    public double getRateOfProfit(final Money spentMoney) {
        Money totalProfit = calculateTotalReword();
        return (double) totalProfit.getValue() / spentMoney.getValue();
    }

    private Money calculateTotalReword() {
        Long totalMoney = lottoStatistics.stream()
                .map(LottoPrize::getReward)
                .reduce(0L, Long::sum);
        return new Money(totalMoney);
    }

    public List<LottoPrize> getLottoStatistics() {
        return Collections.unmodifiableList(lottoStatistics);
    }
}
