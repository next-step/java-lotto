package lotto.domain;

import lotto.exception.LottoApplicationException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new LottoApplicationException("로또 숫자는 6개여야 합니다.");
        }

        this.numbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        String numbersString = numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));

        sb.append(numbersString);
        sb.append("]");

        return sb.toString();
    }

}