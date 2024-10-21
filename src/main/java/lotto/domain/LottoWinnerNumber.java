package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoWinnerNumber {
    private List<Integer> lottoWinnerNumberList;

    public LottoWinnerNumber(List<Integer> lottoWinnerNumberList) {
        this.lottoWinnerNumberList = lottoWinnerNumberList;
    }

    public boolean contains(int requestLottoNumber) {
        return lottoWinnerNumberList.contains(requestLottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoWinnerNumber that = (LottoWinnerNumber) o;
        return Objects.equals(lottoWinnerNumberList, that.lottoWinnerNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoWinnerNumberList);
    }
}
