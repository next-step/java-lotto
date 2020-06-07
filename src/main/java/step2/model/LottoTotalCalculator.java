package step2.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTotalCalculator {
    private Map<WinnerTier, Integer> WinningResult = new HashMap<>();

    public Map<WinnerTier, Integer> countWinners(LottoGame lottoGame, Lotto WinnerLotto) {

        for (WinnerTier winnerTier : WinnerTier.values()) {
            long matchCount = lottoGame.getLottos().stream()
                    .filter(lotto -> lotto.checkWinningCount(WinnerLotto) == winnerTier.getMatchCnt())
                    .count();

            WinningResult.put(winnerTier, (int) matchCount);
        }

        return WinningResult;
    }

    public double returnYield(int lottoMoney) {
        double sum = 0;

        for (WinnerTier winnerTier : WinnerTier.values()) {
            sum += winnerTier.getPrize() * WinningResult.get(winnerTier);
        }

        return Math.floor(sum / lottoMoney * 100) / 100;
    }
}
