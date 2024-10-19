package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinner {
    LottoWinnerNumber lottoWinnerNumber;
    List<Integer> lottoNumbermatchCountList;

    public LottoWinner(List<Integer> lottoWinnerNumberList) {
        this.lottoWinnerNumber = new LottoWinnerNumber(lottoWinnerNumberList);
    }

    public int findMachingCount(List<Integer> lottoNumberList) {
        return lottoNumberList.stream()
                .filter(lottoWinnerNumber::contains)
                .mapToInt(e -> 1)
                .sum();
    }
}
