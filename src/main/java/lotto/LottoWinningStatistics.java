package lotto;

import java.util.*;

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

    public static Map<LottoRank, Integer> getWinningLottoStatistics(List<Lotto> lottos) {

        Map<LottoRank, Integer> winningLottoCountMap = new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = LottoRank.getLottoRank(lotto.getMatchCount(), lotto.getIsBonusMatch());
            winningLottoCountMap.merge(lottoRank, 1, Integer::sum);
        }

        // 내림차순으로 삽입
        List<LottoRank> sortedRanks = LottoRank.getAllLottoRank();
        Collections.reverse(sortedRanks); // 내림차순으로 정렬

        Map<LottoRank, Integer> finalMap = new LinkedHashMap<>();
        for (LottoRank rank : sortedRanks) {
            finalMap.put(rank, winningLottoCountMap.getOrDefault(rank, 0));
        }
        winningLottoCountMap.remove(LottoRank.MISS);

        return finalMap;
    }

}
