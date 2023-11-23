package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {
    private final Lotto winnerLotto;

    public LottoWinningStatistics(Lotto winnerLotto) {
        this.winnerLotto = winnerLotto;
    }

    public List<RankResult> informStatistics(Lottos lottos) {
        Map<Rank, Long> rankStatistics = lottos.seekStatistics(this.winnerLotto);
        return createRankResults(rankStatistics);
    }

    private List<RankResult> createRankResults(Map<Rank, Long> rankStatistics) {
        List<RankResult> rankResults = new ArrayList<>();
        rankStatistics.forEach((rank, numberOfRanks) -> rankResults.add(new RankResult(rank, numberOfRanks)));
        return rankResults;
    }
}
