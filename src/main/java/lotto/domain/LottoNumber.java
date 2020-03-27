package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> lottoNumber;

    LottoNumber(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    public long getMatchCount(LottoNumber winningNumber) {
        return winningNumber.getLottoNumber()
                .stream()
                .filter(lottoNumber::contains)
                .count();
    }

}
