package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatisticsGenerator {

    public static LottoWinningStatistics giveOut(final int lottoPurchaseAmount, final List<Lotto> lottos,
                                                 final Lotto winningLotto) {
        Map<LottoWinningType, Integer> lottoWinningTypeCountMap = countLottoWinningTypes(lottos, winningLotto);
        double yield = calculateYield(lottoPurchaseAmount, lottoWinningTypeCountMap);

        return new LottoWinningStatistics(lottoWinningTypeCountMap, yield);
    }

    private static Map<LottoWinningType, Integer> countLottoWinningTypes(final List<Lotto> lottos,
                                                                         final Lotto winningLotto) {
        Map<LottoWinningType, Integer> countMap = new HashMap<>();

        lottos.forEach(lotto -> {
            LottoWinningType lottoWinningType =
                    LottoWinningType.valueOfMatchNumbersCount(lotto.matchNumberCount(winningLotto));
            countMap.put(lottoWinningType, countMap.getOrDefault(lottoWinningType, 0) + 1);
        });

        return countMap;
    }

    private static double calculateYield(final int lottoPurchaseAmount,
                                         final Map<LottoWinningType, Integer> lottoWinningTypeCountMap) {
        int winningAmountSum = 0;
        for (LottoWinningType lottoWinningType : LottoWinningType.values()) {
            int lottoWinningTypeCount = lottoWinningTypeCountMap.getOrDefault(lottoWinningType, 0);
            winningAmountSum += lottoWinningTypeCount * lottoWinningType.getWinningAmount();
        }
        return floor((double) winningAmountSum / lottoPurchaseAmount, 2);
    }

    private static double floor(final double number, final int decimal) {
        return Math.floor(number * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }
}
