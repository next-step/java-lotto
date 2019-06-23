package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.PurchaseAmount.AMOUNT_PER_LOTTO;
import static lotto.domain.PrizeInfo.PRIZE_INFOS;

public class Statistics {

    private static final double BASE = 1.0;

    private final List<Statistic> statistics;
    private final int purchaseAmount;

    public Statistics(WonNumbers wonNumbers, Lottos lottos) {

        this.statistics = createStatistics(wonNumbers, lottos);
        this.purchaseAmount = lottos.getLottoCount() * AMOUNT_PER_LOTTO;
    }

    public List<Statistic> getStatistics() {

        return statistics;
    }

    public double getEarnRate() {

        return floorEarnRate((double) getWinAmount() / purchaseAmount);
    }

    public boolean isGain() {

        return getEarnRate() >= BASE;
    }

    long getWinAmount() {

        return statistics.stream().mapToLong(Statistic::getEarnMoney).sum();
    }

    private double floorEarnRate(double earnRate) {

        return Math.floor(earnRate * 100) / 100.0;
    }

    private List<Statistic> createStatistics(WonNumbers wonNumbers, Lottos lottos) {

        return PRIZE_INFOS.stream()
                .map(prizeInfo -> Statistic.of(prizeInfo, lottos.countCorrectsByCompareWonNumbers(prizeInfo.getMatchCount(), wonNumbers)))
                .collect(Collectors.toList());
    }
}
