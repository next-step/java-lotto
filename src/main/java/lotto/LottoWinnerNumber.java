package lotto;

import java.util.List;

public class LottoWinnerNumber {
    List<Integer> lottoWinnerNumberList;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumberList) {
        this.lottoWinnerNumberList = lottoWinnerNumberList;
    }

    public boolean contains(int requestLottoNumber) {
        return lottoWinnerNumberList.contains(requestLottoNumber);
    }
}
