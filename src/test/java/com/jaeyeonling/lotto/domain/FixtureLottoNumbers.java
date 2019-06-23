package com.jaeyeonling.lotto.domain;

import java.util.HashSet;

public class FixtureLottoNumbers extends HashSet<LottoNumber> {

    FixtureLottoNumbers() {
        this(Lotto.COUNT_OF_LOTTO_NUMBER);
    }

    FixtureLottoNumbers(final int countOfLottoNumber) {
        for (int lottoNumber = LottoNumber.MIN; lottoNumber <= countOfLottoNumber; lottoNumber++) {
            add(new LottoNumber(lottoNumber));
        }
    }
}
