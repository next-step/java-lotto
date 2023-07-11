package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int DEFAULT_COUNT = 0;

    private final Map<WinningCriteria, Integer> ranks;

    public WinningStatistics(final List<LottoResult> lottoResults) {
        this.ranks = initRanks(lottoResults);
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

    public int getRank(WinningCriteria criteria) {
        return ranks.get(criteria);
    }
}
