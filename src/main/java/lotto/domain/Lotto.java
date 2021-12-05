package lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int compare(List<Integer> winningNumbers) {
        return lottoNumber.compare(winningNumbers);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
