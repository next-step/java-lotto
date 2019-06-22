package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.exception.InvalidCountOfLottoNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    Lotto(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO) {
            throw new InvalidCountOfLottoNumberException();
        }

        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }
}
