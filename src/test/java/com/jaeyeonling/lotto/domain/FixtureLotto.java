package com.jaeyeonling.lotto.domain;

public class FixtureLotto extends Lotto {

    FixtureLotto() {
        super(new FixtureLottoNumbers(COUNT_OF_LOTTO_NUMBER));
    }

    FixtureLotto(final int startLottoNumber) {
        super(new FixtureLottoNumbers(startLottoNumber, COUNT_OF_LOTTO_NUMBER));
    }
}
