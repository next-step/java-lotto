package lotto;

import java.util.List;

public class WinningChecker {
    public WinningStatistic getResult(List<Integer> winningNumbers, List<Lotto> boughtLottos) {
        int totalWinningAmount = 0;
        for (Lotto boughtLotto : boughtLottos) {
            WinningRank winningRank = WinningRank.getWinningRank(winningNumbers, boughtLotto);
            totalWinningAmount += winningRank.winningAmount;
        }
        int earningsRate = totalWinningAmount / (LottoFactory.PRICE_OF_ONE_LOTTO * boughtLottos.size());
        return new WinningStatistic(null, earningsRate);
    }
}
