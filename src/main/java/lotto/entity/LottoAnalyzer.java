package lotto.entity;

import java.util.Arrays;
import java.util.List;

public class LottoAnalyzer {
    private final List<WinningResult> winningResults;

    public LottoAnalyzer() {
        winningResults = Arrays.asList(
                new WinningResult(Rank.FIFTH),
                new WinningResult(Rank.FOURTH),
                new WinningResult(Rank.THIRD),
                new WinningResult(Rank.SECOND),
                new WinningResult(Rank.FIRST)
        );
    }

    public List<WinningResult> analyzer(List<Lotto> lottos, Winning winning) {
        for (Lotto lotto : lottos) {
            int matchCount = winning.matchCount(lotto);
            boolean isCollectBonus = winning.isCollectBonus(lotto);

            Rank rank = Rank.valueOf(matchCount, isCollectBonus);
            process(rank);
        }
        return winningResults;
    }

    private void process(Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }

        for (WinningResult result : winningResults) {
            countUpSame(rank, result);
        }
    }

    private void countUpSame(Rank rank, WinningResult result) {
        if (result.isSame(rank)) {
            increase(result);
        }
    }

    private void increase(WinningResult search) {
        search.increase();
    }
}
