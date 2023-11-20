package lotto.domain;

import java.util.List;

public class LottoNumbers {
    private final LottoNumber lottoNumber;

    public LottoNumbers(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public List<Integer> generateLottoNumbers() {
        return lottoNumber.getNumbers();
    }
}
