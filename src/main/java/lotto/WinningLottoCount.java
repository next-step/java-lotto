package lotto;

import lotto.ui.PrintView;

import java.util.List;
import java.util.Objects;

public class WinningLottoCount {
    public static final int[] LOTTO_WINNING_AMOUNT_ARRAY = {5000, 50000, 1500000, 2000000000};


    List<Integer> winningLottoCountList;

    public WinningLottoCount(List<Integer> winningLottoCountList) {
        this.winningLottoCountList = winningLottoCountList;
    }

    public void recordWinningCount(int winningCountIndex) {
        int countValue = winningLottoCountList.get(winningCountIndex);
        winningLottoCountList.set(winningCountIndex, countValue + 1);
    }

    public void printWinningCount() {
        PrintView.printWinningStatisticsPreview();
        PrintView.printWinningCount(winningLottoCountList);
    }

    public int winningAmount() {
        int winningAmount = 0;
        for (int i = 0; i < winningLottoCountList.size(); i++) {
            winningAmount += LOTTO_WINNING_AMOUNT_ARRAY[i] * winningLottoCountList.get(i);
        }
        return winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLottoCount that = (WinningLottoCount) o;
        return Objects.equals(winningLottoCountList, that.winningLottoCountList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winningLottoCountList);
    }


}
