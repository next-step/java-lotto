package lotto;

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

    public void printMatchingCount() {
        for (int i = 0; i < lottoNumberMatchCountList.size(); i++) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", i + 3, LOTTO_WINNING_AMOUNT_ARRAY[i], lottoNumberMatchCountList.get(i));
        }
    }

    public int winningAmount() {
        int winningAmount = 0;
        for (int i = 0; i < lottoNumberMatchCountList.size(); i++) {
            winningAmount += LOTTO_WINNING_AMOUNT_ARRAY[i] * lottoNumberMatchCountList.get(i);
        }
        return winningAmount;
    }
}
