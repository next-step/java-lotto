package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {
    private static final List<Integer> MATCHING_COUNT_FOR_WINNING = Arrays.asList(3, 4, 5, 6);

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

    //todo 이 메서드의 위치가 LottoWinningStatistics에 있어야 할 것 같아서 이곳에 작성
    // MATCHING_COUNT_FOR_WINNING 중복 작성됨
    public static Map<Integer, Integer> getWinningLottoStatistics(List<Lotto> lottos) {
        Map<Integer, Integer> winningLottoCountMap = new HashMap<>();

        for (Integer matchCount : MATCHING_COUNT_FOR_WINNING) {
            winningLottoCountMap.put(matchCount, getWinningLottoCountByMatchCount(lottos, matchCount));
        }
        return winningLottoCountMap;
    }

    private static int getWinningLottoCountByMatchCount(List<Lotto> lottos, int matchCount) {
        int lottoCount = 0;
        for (Lotto lotto : lottos) {
            lottoCount += lotto.isEqualMatchCount(matchCount);
        }
        return lottoCount;
    }

}
