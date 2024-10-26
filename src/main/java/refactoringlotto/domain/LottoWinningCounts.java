package refactoringlotto.domain;

import lotto.domain.LottoWinningCountDecision;

import java.util.*;

public class LottoWinningCounts {
    private final static int DEFAULT_WINNING_COUNT = 0;
    Map<Integer, Integer> lottoWinningCountsMap;

    public LottoWinningCounts() {
        this(initCountsMap());
    }

    private static Map<Integer, Integer> initCountsMap() {
        Map<Integer, Integer> winningLottoCountMap = new TreeMap<>(Comparator.reverseOrder());
        Arrays.asList(4, 3, 2, 1).forEach(i -> winningLottoCountMap.put(i, DEFAULT_WINNING_COUNT));
        return winningLottoCountMap;
    }

    public LottoWinningCounts(Map<Integer, Integer> winningCountsMap) {
        lottoWinningCountsMap = winningCountsMap;
    }

    public void updateWinningCountList(List<Integer> lottoRankList) {
        for (int lottoRank : lottoRankList) {
            updateWinningCount(lottoRank);
        }
    }

    public void updateWinningCount(int lottoRank) {
        lottoWinningCountsMap.compute(lottoRank, (key, value) -> value + 1);
    }

    public Map<Integer, Integer> getLottoWinningCountsMap() {
        return lottoWinningCountsMap;
    }

    public int winningAmount() {
        int winningAmount = 0;
        for (int rank : lottoWinningCountsMap.keySet()) {
            winningAmount += LottoWinningCountDecision.convertMatchingRankToAmount(rank) * lottoWinningCountsMap.get(rank);
        }
        return winningAmount;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinningCounts that = (LottoWinningCounts) o;
        return Objects.equals(lottoWinningCountsMap, that.lottoWinningCountsMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoWinningCountsMap);
    }
}
