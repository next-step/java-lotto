package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.InvalidCountOfLottoNumberException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto implements Dealable {

    public static final int COUNT_OF_LOTTO_NUMBER = 6;
    static final int PRICE_VALUE = 1_000;

    static final Money PRICE = new Money(PRICE_VALUE);

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != COUNT_OF_LOTTO_NUMBER) {
            throw new InvalidCountOfLottoNumberException(lottoNumbers.size());
        }

        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    int countOfMatch(final Lotto expect) {
        return (int) lottoNumbers.stream()
                .filter(expect.lottoNumbers::contains)
                .count();
    }

    @Override
    public Money getPrice() {
        return PRICE;
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

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
