package lotto.domain;

import java.util.*;

public class LottoNumber {
    private final LottoNumbers lottoNumbers;

    public LottoNumber(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> generateLottoNumbers() {
        return lottoNumbers.getNumbers();
    }
}
