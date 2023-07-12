package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningStatistics {

    private static final int DEFAULT_COUNT = 0;

    private final Map<WinningCriteria, Integer> ranks;
    private final long totalPrize;
    private final int boughtLottoCount;
    private final double earningRate;

    public WinningStatistics(final List<LottoResult> lottoResults) {
        this.ranks = initRanks(lottoResults);
        this.totalPrize = initTotalPrize();
        this.boughtLottoCount = lottoResults.size();
        this.earningRate = totalPrize / (double) (boughtLottoCount * Lotto.PRICE);
    }

    private Map<WinningCriteria, Integer> initRanks(final List<LottoResult> lottoResults) {
        Map<WinningCriteria, Integer> ranks = new HashMap<>();

        for (WinningCriteria value : WinningCriteria.values()) {
            ranks.put(value, DEFAULT_COUNT);
        }

        for (LottoResult lottoResult : lottoResults) {
            WinningCriteria winningCriteria = lottoResult.getWinningCriteria();
            ranks.put(winningCriteria, ranks.getOrDefault(winningCriteria, DEFAULT_COUNT) + 1);
        }

        return ranks;
    }

    private long initTotalPrize() {
        long sum = 0L;
        for (Entry<WinningCriteria, Integer> entry : ranks.entrySet()) {
            sum += (entry.getKey().getPrize() * (long) entry.getValue());
        }
        return sum;
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
