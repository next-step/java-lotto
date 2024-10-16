package lotto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LottoResultAnalyzer {
    private final List<WinningResult> winningResults;

    public LottoResultAnalyzer() {
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
            Set<Integer> winningNumbers = winning.getWinningNumbers().getNumbers();
            int bonusNumber = winning.getBonusNumber();
            Rank rank = Rank.valueOf(lotto.matchCount(winningNumbers), lotto.isCollectBonusNumber(bonusNumber));
            process(rank);
        }
        return winningResults;
    }

    private void process(Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }
        winningResults.stream().filter(w -> w.isSame(rank)).forEach(w -> increase(w));
    }

    private void increase(WinningResult search) {
        search.increase();
    }
}
