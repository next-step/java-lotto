package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<Rank, Long> winningStatistics;

    public WinningStatistics(Lottos lottos, WinningLotto winningLotto) {
        List<LottoMatch> lottoMatches = lottos.compareLottos(winningLotto);

        Map<Rank, Long> rankMap = new HashMap<>();

        for (LottoMatch lottoMatch : lottoMatches) {
            rankMap.put(Rank.fromLottoMatch(lottoMatch), rankMap.getOrDefault(Rank.fromLottoMatch(lottoMatch), 0L) + 1);
        }
        winningStatistics = rankMap;
    }

    public Map<Rank, Long> getWinningStatistics() {
        return winningStatistics;
    }

    public Long getRankCount(Rank rank) {
        return winningStatistics.getOrDefault(rank, 0L);
    }
}
