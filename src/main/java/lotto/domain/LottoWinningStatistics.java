package lotto.domain;

import java.util.Map;

public class LottoWinningStatistics {
    private final Lotto winnerLotto;

    public LottoWinningStatistics(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    public RankResult informStatistics(Lottos lottos) {
        Map<Rank, Long> rankStatistics = lottos.seekRankStatistics(this.winnerLotto);
        return createRankResults(rankStatistics);
    }

    private RankResult createRankResults(Map<Rank, Long> rankStatistics) {
        return new RankResult(rankStatistics);
    }
}
