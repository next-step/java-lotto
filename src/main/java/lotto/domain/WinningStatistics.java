package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WinningStatistics {

    private static final int DEFAULT_COUNT = 0;
    private static final String EMPTY_LOTTO_RESULTS_EXCEPTION_MESSAGE = "당첨 결과가 비어있어 통계를 낼 수 없습니다.";

    private final Map<WinningCriteria, Integer> ranks;
    private final long totalPrize;
    private final double earningRate;

    public WinningStatistics(final List<LottoResult> lottoResults) {
        validate(lottoResults);
        this.ranks = initRanks(lottoResults);
        this.totalPrize = initTotalPrize();
        this.earningRate = totalPrize / (double) (lottoResults.size() * Lotto.PRICE);
    }

    private void validate(final List<LottoResult> lottoResults) {
        if (lottoResults == null || lottoResults.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_LOTTO_RESULTS_EXCEPTION_MESSAGE);
        }
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
