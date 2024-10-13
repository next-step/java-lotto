package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static lotto.domain.LottoNumbersValidation.*;

public class LottoNumbers {
    private static final List<LottoNumbersValidation> LOTTO_NUMBERS_VALIDATION_LIST = List.of(LOTTO_NUMBERS_COUNT_INVALID, LOTTO_NUMBERS_IS_OUT_OF_RANGE, LOTTO_NUMBERS_HAS_DUPLICATED_NUMBER);
    private final List<LottoNumber> value;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.value = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        for (LottoNumbersValidation validation : LOTTO_NUMBERS_VALIDATION_LIST) {
            validation.check(numbers);
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }

        List<LottoNumber> sortedNumbers = sortNumbers(lottoNumbers);
        return new LottoNumbers(sortedNumbers);
    }

    private static List<LottoNumber> sortNumbers(List<LottoNumber> numbers) {
        List<LottoNumber> mutableNumbers = new ArrayList<>(numbers);
        mutableNumbers.sort(Comparator.comparingInt(LottoNumber::value));
        return mutableNumbers;
    }

    public List<Integer> value() {
        List<Integer> numbers = new ArrayList<>();
        for (LottoNumber lottoNumber : value) {
            numbers.add(lottoNumber.value());
        }
        return numbers;
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
