package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<Integer> value;

    private LottoNumbers(List<Integer> numbers) {
        this.value = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        for (LottoNumbersValidation validation : LottoNumbersValidation.values()) {
            validation.check(numbers);
        }
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return new LottoNumbers(mutableNumbers);
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
