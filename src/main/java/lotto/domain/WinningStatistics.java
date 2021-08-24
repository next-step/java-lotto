package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Long> winningStatistics;

    public WinningStatistics(Lottos lottos, WinningLotto winningLotto) {
        List<Rank> lottoMatches = lottos.compareLottos(winningLotto);

        Map<Rank, Long> rankMap = new HashMap<>();

        for (Rank rank : lottoMatches) {
            rankMap.put(rank, rankMap.getOrDefault(rank, 0L) + 1);
        }
        winningStatistics = rankMap;
    }

    public Long getRankCount(Rank rank) {
        return winningStatistics.getOrDefault(rank, 0L);
    }
}
