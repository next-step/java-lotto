package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoNumbersValidation.*;

public class LottoNumbers {
    private static final List<LottoNumbersValidation> LOTTO_NUMBERS_VALIDATION_LIST = List.of(LOTTO_NUMBERS_COUNT_INVALID, LOTTO_NUMBERS_IS_OUT_OF_RANGE, LOTTO_NUMBERS_HAS_DUPLICATED_NUMBER);
    private final List<Integer> value;

    private LottoNumbers(List<Integer> numbers) {
        this.value = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        for (LottoNumbersValidation validation : LOTTO_NUMBERS_VALIDATION_LIST) {
            validation.check(numbers);
        }
        List<Integer> sortedNumbers = sortNumbers(numbers);
        return new LottoNumbers(sortedNumbers);
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return mutableNumbers;
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
