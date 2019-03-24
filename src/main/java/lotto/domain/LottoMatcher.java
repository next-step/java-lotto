package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoMatcher {

    public static MatchResults calculateMatchResults(final LottoList lottos, final WinningLotto winningLotto) {
        MatchResults matchResults = new MatchResults();

        List<Rank> ranks = Arrays.asList(Rank.values());

        for (Rank rank : ranks) {
            matchResults.put(
                rank, new RankCount(rank, lottos.count(rank, winningLotto)));
        }

        return matchResults;
    }
}
