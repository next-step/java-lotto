package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    public static final int LOTTO_NUMBERS_CARDINALITY = 6;
    private static final String LOTTO_NUMBERS_COUNT_INVALID_MESSAGE = "로또 숫자 갯수가 다릅니다.";
    private static final String LOTTO_NUMBERS_HAS_DUPLICATED_NUMBER_MESSAGE = "중복된 숫자가 존재합니다.";
    private final List<LottoNumber> value;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.value = numbers;
    }

    public static LottoNumbers valueOf(List<Integer> numbers) {
        checkLottoNumbersValid(numbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }

        List<LottoNumber> sortedNumbers = sortNumbers(lottoNumbers);
        return new LottoNumbers(sortedNumbers);
    }

    private static void checkLottoNumbersValid(List<Integer> lottoNumbers) {
        checkLottoNumbersCountValid(lottoNumbers);
        checkLottoNumbersNotDuplicated(lottoNumbers);
    }

    private static void checkLottoNumbersCountValid(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() == LOTTO_NUMBERS_CARDINALITY) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_COUNT_INVALID_MESSAGE);
        }
    }

    private static void checkLottoNumbersNotDuplicated(List<Integer> lottoNumbers) {
        Set<Integer> lottoNumbersSet = new HashSet<>(lottoNumbers);
        if (lottoNumbersSet.size() == lottoNumbers.size()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_HAS_DUPLICATED_NUMBER_MESSAGE);
        }
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
