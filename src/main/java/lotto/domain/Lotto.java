package lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getWinningCount(List<Integer> winningNumbers) {
        return lottoNumber.compareTo(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
