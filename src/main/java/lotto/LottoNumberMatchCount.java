package lotto;

import lotto.ui.PrintView;

import java.util.List;
import java.util.Objects;

public class LottoNumberMatchCount {
    public static final int[] LOTTO_WINNING_AMOUNT_ARRAY = {5000, 50000, 1500000, 2000000000};


    List<Integer> lottoNumberMatchCountList;

    public LottoNumberMatchCount(List<Integer> lottoNumberMatchCountList) {
        this.lottoNumberMatchCountList = lottoNumberMatchCountList;
    }

    public void updateMatchingCount(int matchingCountIndex) {
        int countValue = lottoNumberMatchCountList.get(matchingCountIndex);
        lottoNumberMatchCountList.set(matchingCountIndex, countValue + 1);
    }

    public void printMatchingCount() {
        PrintView.printWinningStatisticsPreview();
        PrintView.printMatchingCount(lottoNumberMatchCountList);
    }

    public int winningAmount() {
        int winningAmount = 0;
        for (int i = 0; i < lottoNumberMatchCountList.size(); i++) {
            winningAmount += LOTTO_WINNING_AMOUNT_ARRAY[i] * lottoNumberMatchCountList.get(i);
        }
        return winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberMatchCount that = (LottoNumberMatchCount) o;
        return Objects.equals(lottoNumberMatchCountList, that.lottoNumberMatchCountList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumberMatchCountList);
    }


}
