package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private final Map<WinningCriteria, Integer> ranks;

    public WinningStatistics(final List<LottoResult> lottoResults) {
        this.ranks = new HashMap<>();
        for (WinningCriteria value : WinningCriteria.values()) {
            ranks.put(value, 0);
        }

        for (LottoResult lottoResult : lottoResults) {
            WinningCriteria winningCriteria = lottoResult.getWinningCriteria();
            ranks.put(winningCriteria, ranks.getOrDefault(winningCriteria, 0) + 1);
        }
    }

    public int getRank(WinningCriteria criteria) {
        return ranks.get(criteria);
    }
}
