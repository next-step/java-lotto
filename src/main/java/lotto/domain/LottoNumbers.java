package lotto.domain;

import java.util.List;

public class LottoNumbers<T> {
    private final List<T> lottoNumbers;

    public LottoNumbers(List<T> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }
}
