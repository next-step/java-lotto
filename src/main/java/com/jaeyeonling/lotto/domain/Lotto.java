package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.exception.InvalidCountOfLottoNumberException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto implements Dealable {

    private static final Money LOTTO_PRICE = new Money(Env.PRICE_OF_LOTTO);
    private final List<LottoNumber> lottoNumbers;

    Lotto(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO) {
            throw new InvalidCountOfLottoNumberException(lottoNumbers.size());
        }

        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    int countOfMatch(final Lotto expect) {
        return (int) lottoNumbers.stream()
                .filter(expect.lottoNumbers::contains)
                .count();
    }

    @Override
    public Money getPrice() {
        return LOTTO_PRICE;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }

        final Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
