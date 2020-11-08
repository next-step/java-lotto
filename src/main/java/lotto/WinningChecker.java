package lotto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    public WinningStatistic getResult(Collection<Integer> winningNumbers, Collection<Lotto> boughtLottos) {
        List<WinningRank> winningRanks = getWinningRanks(winningNumbers, boughtLottos);
        Map<WinningRank, Integer> countOfWinningRanks = getCountOfWinningRanks(winningRanks);
        String earningsRate = getEarningsRate(winningRanks, boughtLottos.size());

        return new WinningStatistic(countOfWinningRanks, earningsRate);
    }

    private List<WinningRank> getWinningRanks(Collection<Integer> winningNumbers, Collection<Lotto> boughtLottos) {
        List<WinningRank> winningRanks = new ArrayList<>();
        for (Lotto boughtLotto : boughtLottos) {
            winningRanks.add(WinningRank.getWinningRank(winningNumbers, boughtLotto));
        }
        return winningRanks;
    }

    private Map<WinningRank, Integer> getCountOfWinningRanks(List<WinningRank> winningRanks) {
        EnumMap<WinningRank, Integer> countOfWinningRanks = new EnumMap<>(WinningRank.class);
        for (WinningRank winningRank : winningRanks) {
            countOfWinningRanks.put(winningRank, countOfWinningRanks.getOrDefault(winningRank, 0) + 1);
        }
        return countOfWinningRanks;
    }

    private String getEarningsRate(List<WinningRank> winningRanks, int boughtLottosSize) {
        BigDecimal totalWinningAmount = BigDecimal.valueOf(WinningRank.getTotalWinningAmount(winningRanks));
        BigDecimal totalPurchaseAmount = BigDecimal.valueOf(LottoFactory.PRICE_OF_ONE_LOTTO * boughtLottosSize);
        return totalWinningAmount.divide(totalPurchaseAmount, MathContext.DECIMAL32).toString();
    }
}
