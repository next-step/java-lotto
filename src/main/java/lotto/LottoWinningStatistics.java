package lotto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoWinningStatistics {
    public static int calculateTotalWinningAmount(List<Lotto> lottos) {
        int winningAmount = 0;
        for (Lotto lotto : lottos) {
            winningAmount += lotto.getAmount();
        }
        return winningAmount;
    }

    public static double calculateRateOfReturn(int winningAmount, int paidAmount) {
        return Math.floor(((double) winningAmount / paidAmount) * 100) / 100;
    }

    public static Map<Integer, Integer> getWinningLottoStatistics(List<Lotto> lottos) {
        Map<Integer, Integer> winningLottoCountMap = lottos.stream()
                .map(Lotto::getMatchCount)
                .filter(LottoRank.getMatchCounts()::contains)
                .collect(Collectors.toMap(
                        matchCount -> matchCount,
                        matchCount -> 1,
                        Integer::sum
                ));

        for (Integer matchCount : LottoRank.getMatchCounts()) {
            winningLottoCountMap.putIfAbsent(matchCount, 0);
        }

        return winningLottoCountMap;
    }

}
