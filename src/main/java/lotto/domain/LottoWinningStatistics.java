package lotto.domain;

import java.util.Map;

public class LottoWinningStatistics {
    private final WinnerLotto winnerLotto;

    public LottoWinningStatistics(WinnerLotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    public RankResult informStatistics(Lottos lottos) {
        Map<Rank, Long> rankStatistics = lottos.seekRankStatistics(winnerLotto);
        return createRankResults(rankStatistics);
    }

    private RankResult createRankResults(Map<Rank, Long> rankStatistics) {
        return new RankResult(rankStatistics);
    }
}
