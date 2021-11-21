package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private static final int DEFALUT_RANK_COUNT = 0;
    private static final int COUNT_ADD_VALUE = 1;

    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> rankCount) {
        this.winningStatistics = rankCount;
    }

    public static WinningStatistics from(Lottos lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> winningStatistics = new HashMap<>();

        List<Lotto> lottoList = lottos.getLottos();

        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.matchCount(lotto);
            Rank rank = Rank.from(matchCount);

            int count = winningStatistics.getOrDefault(rank, DEFALUT_RANK_COUNT);
            winningStatistics.put(rank, count + COUNT_ADD_VALUE);
        }

        return new WinningStatistics(winningStatistics);
    }

    public int rankCount(Rank rank) {
        return winningStatistics.getOrDefault(rank, DEFALUT_RANK_COUNT);
    }
}
