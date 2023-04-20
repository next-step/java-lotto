package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoStrategy lottoStrategy) {
        this.lottoNumbers = lottoStrategy.lottoNumbers();
    }
}
