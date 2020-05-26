package lotto.domain.result;

import java.util.Collections;
import java.util.List;

public class LottoResult {
    private final List<LottoPrize> lottoStatistics;

    public LottoResult(List<LottoPrize> lottoPrizes) {
        this.lottoStatistics = lottoPrizes;
    }

    public int getNumberOfHitTickets(final int hitCount) {
        return Math.toIntExact(lottoStatistics.stream()
                .filter(lottoPrize -> lottoPrize.getHitCount() == hitCount)
                .count());
    }

    public double getRateOfProfit(final int spentMoney) {
        long totalProfit = LottoPrize.calculateTotalReword(lottoStatistics);
        return (double) totalProfit / spentMoney;
    }

    public List<LottoPrize> getLottoStatistics() {
        return Collections.unmodifiableList(lottoStatistics);
    }
}
