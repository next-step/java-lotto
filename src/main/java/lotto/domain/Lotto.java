package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto(List<Number> numbers) {
        this.numbers = new LottoNumbers(numbers);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.numbers = lottoNumbers;
    }

    public static Lotto from(String input) {
        return new Lotto((new LottoNumbers(input)));
    }

    public LottoNumbers numbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public boolean isValidRange() {
        return numbers.isValidRange();
    }

    public boolean isSorted() {
        return numbers.isSorted();
    }
}
