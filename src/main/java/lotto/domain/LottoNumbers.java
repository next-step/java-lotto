package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private List<Integer> value;

    LottoNumbers(List<Integer> numbers) {
        this.value = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        for (LottoNumbersValidation validation : LottoNumbersValidation.values()) {
            validation.check(numbers);
        }
        return new LottoNumbers(numbers);
    }

    public List<Integer> value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
