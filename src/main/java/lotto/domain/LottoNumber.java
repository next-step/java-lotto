package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    public LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public String getNumberToString() {
        return lottoNumber.toString();
    }

    public long getMatchCountInLottoNumber(LottoNumber winningNumber) {
        return winningNumber.getLottoNumber()
                .stream()
                .filter(lottoNumber::contains)
                .count();
    }

    protected List<Integer> getLottoNumber() {
        return lottoNumber;
    }

}
