package lotto.domain;

import java.util.Map;

public class LottoWinningStatistics {
    private final Lotto winnerLotto;
    private final Bonus bonus;


    public LottoWinningStatistics(Lotto winnerLotto, Bonus bonus) {
        this.winnerLotto = winnerLotto;
        this.bonus = bonus;
    }

    public RankResult informStatistics(Lottos lottos) {
        Map<Rank, Long> rankStatistics = lottos.seekRankStatistics(this.winnerLotto, this.bonus);
        return createRankResults(rankStatistics);
    }

    private RankResult createRankResults(Map<Rank, Long> rankStatistics) {
        return new RankResult(rankStatistics);
    }
}
