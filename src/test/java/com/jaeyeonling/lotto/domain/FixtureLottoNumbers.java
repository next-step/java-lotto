package com.jaeyeonling.lotto.domain;

import java.util.HashSet;

public class FixtureLottoNumbers extends HashSet<LottoNumber> {

    FixtureLottoNumbers(final int countOfLottoNumber) {
        this(LottoNumber.MIN, countOfLottoNumber);
    }

    FixtureLottoNumbers(final int startLottoNumber,
                        final int countOfLottoNumber) {
        final int endLottoNumber = startLottoNumber + countOfLottoNumber - LottoNumber.MIN;
        for (int lottoNumber = startLottoNumber; lottoNumber <= endLottoNumber; lottoNumber++) {
            add(new LottoNumber(lottoNumber));
        }
    }
}
