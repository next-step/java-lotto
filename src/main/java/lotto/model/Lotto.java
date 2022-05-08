package lotto.model;

import lotto.enums.Grade;
import lotto.exception.LottoLengthException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Lotto {

    private static final int DEFAULT_LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers
                .stream().map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public static Lotto from(Set<Integer> winnerNumbers) {
        return new Lotto(winnerNumbers);
    }

    private void validate(Set<Integer> lottoNumbers) {
        if (DEFAULT_LOTTO_SIZE != lottoNumbers.size()) {
            throw new LottoLengthException();
        }
    }


    public Set<Integer> numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::currentNumber)
                .collect(Collectors.toSet());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
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