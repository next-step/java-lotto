package lotto;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lottos.AMOUNT_PER_LOTTO;
import static lotto.WinInfo.WIN_INFOS;

public class Statistics {

    private static final int BASE = 1;

    private final List<Statistic> statistics;
    private final int purchaseAmount;

    public Statistics(LastWeekNumbers lastWeekNumbers, Lottos lottos) {

        this.statistics = WIN_INFOS.stream()
                .map(winInfo -> new Statistic(winInfo, lottos.getLastWeekNumbersCorrectCount(winInfo.getMatchCount(), lastWeekNumbers)))
                .collect(Collectors.toList());
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
}
