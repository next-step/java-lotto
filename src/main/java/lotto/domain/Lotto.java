package lotto.domain;

import java.util.List;

public class Lotto {
    private final LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int matchedCount(List<Integer> winningNumber) {
        return lottoNumber.compareTo(winningNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
