package lotto.service.helper;

import lotto.domain.Lotto;
import lotto.domain.WinningRank;
import lotto.dto.Lottos;
import lotto.dto.WinningNumber;
import lotto.dto.WinningStatistic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningChecker {
    private WinningChecker() {

    }

    public static WinningStatistic getResult(WinningNumber winningNumber, Lottos boughtLottos) {
        List<WinningRank> winningRanks = boughtLottos.getWinningRanks(winningNumber);
        Map<WinningRank, Integer> countOfWinningRanks = getCountOfWinningRanks(winningRanks);
        String earningsRate = getEarningsRate(winningRanks, boughtLottos.size());

        return new WinningStatistic(countOfWinningRanks, earningsRate);
    }

    private static Map<WinningRank, Integer> getCountOfWinningRanks(List<WinningRank> winningRanks) {
        Map<WinningRank, Integer> countOfWinningRanks = new EnumMap<>(WinningRank.class);
        for (WinningRank winningRank : winningRanks) {
            countOfWinningRanks.put(winningRank, countOfWinningRanks.getOrDefault(winningRank, 0) + 1);
        }
        return countOfWinningRanks;
    }

    private static String getEarningsRate(List<WinningRank> winningRanks, int boughtLottosSize) {
        BigDecimal totalWinningAmount = BigDecimal.valueOf(WinningRank.getTotalWinningAmount(winningRanks));
        BigDecimal totalPurchaseAmount = BigDecimal.valueOf(Lotto.PRICE_OF_ONE_LOTTO * boughtLottosSize);
        return totalWinningAmount.divide(totalPurchaseAmount, MathContext.DECIMAL32).toString();
    }
}
