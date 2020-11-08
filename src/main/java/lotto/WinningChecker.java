package lotto;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    public WinningStatistic getResult(List<Integer> winningNumbers, List<Lotto> boughtLottos) {
        List<WinningRank> winningRanks = getWinningRanks(winningNumbers, boughtLottos);
        Map<WinningRank, Integer> numberOfWinningRanks = getNumberOfWinningRanks(winningRanks);
        int earningsRate = getEarningsRate(winningRanks, boughtLottos.size());

        return new WinningStatistic(numberOfWinningRanks, earningsRate);
    }

    private List<WinningRank> getWinningRanks(List<Integer> winningNumbers, List<Lotto> boughtLottos) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto boughtLotto : boughtLottos) {
            winningRanks.add(WinningRank.getWinningRank(winningNumbers, boughtLotto));
        }
        return winningRanks;
    }

    private Map<WinningRank, Integer> getNumberOfWinningRanks(List<WinningRank> winningRanks) {
        EnumMap<WinningRank, Integer> numberOfWinningRanks = new EnumMap<>(WinningRank.class);
        for (WinningRank winningRank : winningRanks) {
            numberOfWinningRanks.put(winningRank, numberOfWinningRanks.getOrDefault(winningRank, 0) + 1);
        }
        return numberOfWinningRanks;
    }

    private int getEarningsRate(List<WinningRank> winningRanks, int boughtLottosSize) {
        int totalWinningAmount = winningRanks.stream()
                .mapToInt(r -> r.winningAmount)
                .sum();

        return totalWinningAmount / (LottoFactory.PRICE_OF_ONE_LOTTO * boughtLottosSize);
    }
}
