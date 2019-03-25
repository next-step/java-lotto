package lotto.domain;

public class LottoMatcher {

    public static MatchResults calculateMatchResults(final LottoList lottos, final WinningLotto winningLotto) {
        MatchResults matchResults = new MatchResults();

        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            matchResults.put(
                rank, new RankCount(rank, lottos.count(rank, winningLotto)));
        }

        return matchResults;
    }
}
