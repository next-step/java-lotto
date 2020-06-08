package step2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTotalCalculator {
    private Map<WinnerTier, Integer> winningResult = new HashMap<>();

    public Map<WinnerTier, Integer> countWinners(List<Lotto> lottoGame, Lotto winnerLotto) {

        for (WinnerTier winnerTier : WinnerTier.values()) {
            long matchCount = lottoGame.stream()
                    .filter(lotto -> lotto.checkWinningCount(winnerLotto) == winnerTier.getMatchCnt())
                    .count();

            winningResult.put(winnerTier, (int) matchCount);
        }

        return winningResult;
    }
}
