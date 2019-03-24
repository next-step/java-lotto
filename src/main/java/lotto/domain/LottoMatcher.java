package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class LottoMatcher {

    public static WinningResults calculateWinningResults(final LottoList lottos, final WinningLotto winningLotto) {
        WinningResults winningResults = new WinningResults();

        List<Rank> ranks = Arrays.asList(Rank.values());

        for (Rank rank : ranks) {
            winningResults.put(
                rank, new RankCount(rank, lottos.count(rank, winningLotto)));
        }

        return winningResults;
    }
}
