package lotto.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoResults;
import lotto.domain.WinningCriteria;

public class WinningStatistics {

    private static final int DEFAULT_COUNT = 0;
    private static final int PRICE = 1000;

    private final Map<WinningCriteria, Integer> ranks;
    private final long totalPrize;
    private final double earningRate;

    public WinningStatistics(final LottoResults lottoResults) {
        this.ranks = initRanks(lottoResults);
        this.totalPrize = initTotalPrize();
        this.earningRate = totalPrize / (double) (lottoResults.getLottoResults().size() * PRICE);
    }

    private Map<WinningCriteria, Integer> initRanks(final LottoResults lottoResults) {
        Map<WinningCriteria, Integer> ranks = new HashMap<>();

        for (WinningCriteria value : WinningCriteria.values()) {
            ranks.put(value, DEFAULT_COUNT);
        }

        for (WinningCriteria winningCriteria : lottoResults.getLottoResults()) {
            ranks.put(winningCriteria, ranks.getOrDefault(winningCriteria, DEFAULT_COUNT) + 1);
        }

        return ranks;
    }

    private long initTotalPrize() {
        return Arrays.stream(WinningCriteria.values())
                .mapToLong(criteria -> criteria.getPrize() * ranks.get(criteria))
                .sum();
    }

    public int getRank(final WinningCriteria criteria) {
        return ranks.get(criteria);
    }

    public double getEarningRate() {
        return this.earningRate;
    }

    public long getTotalPrize() {
        return this.totalPrize;
    }
}
