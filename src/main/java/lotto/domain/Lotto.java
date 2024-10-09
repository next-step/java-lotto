package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto valueOf(List<Integer> numbers) {
        for (LottoNumbersValidation validation : LottoNumbersValidation.values()) {
            validation.check(numbers);
        }

        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }
}
