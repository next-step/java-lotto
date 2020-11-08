package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningChecker {
    public WinningStatistic getResult(List<Integer> winningNumbers, List<Lotto> boughtLottos) {
        List<WinningRank> winningRanks = getWinningRanks(winningNumbers, boughtLottos);
        int earningsRate = getEarningsRate(winningRanks, boughtLottos.size());

        return new WinningStatistic(null, earningsRate);
    }

    private List<WinningRank> getWinningRanks(List<Integer> winningNumbers, List<Lotto> boughtLottos) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto boughtLotto : boughtLottos) {
            winningRanks.add(WinningRank.getWinningRank(winningNumbers, boughtLotto));
        }
        return winningRanks;
    }

    private int getEarningsRate(List<WinningRank> winningRanks, int boughtLottosSize) {
        int totalWinningAmount = winningRanks.stream()
                .mapToInt(r -> r.winningAmount)
                .sum();

        return totalWinningAmount / (LottoFactory.PRICE_OF_ONE_LOTTO * boughtLottosSize);
    }
}
