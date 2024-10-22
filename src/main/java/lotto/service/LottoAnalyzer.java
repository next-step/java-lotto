package lotto.service;

import lotto.common.WinningInfo;
import lotto.model.Lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {

    private LottoAnalyzer() {
    }

    public static Map<Integer, Integer> calculateWinningStatics(List<Integer> winningNumbers, int bonusNumber, List<Lotto> lottos) {
        Map<Integer, Integer> winningStatics = createWinningStatisticsMap();

        for (Lotto lotto : lottos) {
            int matchingCount = lotto.countMatchingNumber(winningNumbers);
            boolean isMatchBonusNumber = lotto.containsBonusNumber(bonusNumber);
            int lottoRank = LottoRank.determineRank(matchingCount, isMatchBonusNumber);

            winningStatics.put(lottoRank, winningStatics.get(lottoRank) + 1);
        }

        return winningStatics;
    }

    private static Map<Integer, Integer> createWinningStatisticsMap() {
        Map<Integer, Integer> winningStatics = new HashMap<>();

        for(int rank = 0; rank <= 5; rank++) {
            winningStatics.putIfAbsent(rank, 0);
        }

        return winningStatics;
    }

    public static float calculateReturnRate(int buyAmount, Map<Integer, Integer> winningStatics) {
        int totalPrize = calculatePrize(winningStatics);

        return (float) totalPrize / buyAmount;
    }

    private static int calculatePrize(Map<Integer, Integer> winningStatics) {
        int totalPrize = 0;

        for (int rank = 1; rank <= 5; rank++) {
            totalPrize += winningStatics.get(rank) * WinningInfo.PRIZE[rank];
        }

        return totalPrize;
    }
}
