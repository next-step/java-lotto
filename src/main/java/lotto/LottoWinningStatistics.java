package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoWinningStatistics {

    public static int calculateTotalWinningAmount(List<Lotto> lottos) {
        int winningAmount = 0;
        for (Lotto lotto : lottos) {
            winningAmount += lotto.getAmount();
        }
        return winningAmount;
    }

    public static Map<Integer, Integer> getWinningLottoStatistics(List<Lotto> lottos) {
        Map<Integer, Integer> winningLottoMap = new HashMap<>();
        winningLottoMap.put(3, 0);
        winningLottoMap.put(4, 0);
        winningLottoMap.put(5, 0);
        winningLottoMap.put(6, 0);

        //todo
        for (Lotto lotto : lottos) {
            if (lotto.isWinningLotto()) {
                winningLottoMap.put(lotto.getMatchCount(), winningLottoMap.get(lotto.getMatchCount()) + 1);
            }
        }
        return winningLottoMap;
    }

    public static double calculateRateOfReturn(int winningAmount, int paidAmount) {
        return Math.floor(((double) winningAmount / paidAmount) * 100) / 100;
    }
}
