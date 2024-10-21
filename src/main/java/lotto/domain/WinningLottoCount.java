package lotto.domain;

import lotto.ui.PrintView;

import java.util.Map;
import java.util.Objects;

public class WinningLottoCount {

    Map<Integer, Integer> winningLottoCountMap;

    public WinningLottoCount(Map<Integer, Integer> winningLottoCountMap) {
        this.winningLottoCountMap = winningLottoCountMap;
    }

    public void recordWinningCount(int rank) {
        winningLottoCountMap.compute(rank, (key, rankCount) -> (key == null) ? 1 : rankCount + 1);
    }

    public void printWinningCount() {
        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(winningLottoCountMap);
    }

    public int winningAmount() {
        int winningAmount = 0;
        for (int rank : winningLottoCountMap.keySet()) {
            winningAmount += LottoWinningCountDecision.convertMatchingRankToAmount(rank) * winningLottoCountMap.get(rank);
        }
        return winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoCount that = (WinningLottoCount) o;
        return Objects.equals(winningLottoCountMap, that.winningLottoCountMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winningLottoCountMap);
    }
}
