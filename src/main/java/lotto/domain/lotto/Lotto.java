package lotto.domain.lotto;

import lotto.domain.exception.InvalidCountLottoNumbersException;
import lotto.domain.exception.InvalidDuplicatedLottoNumbersException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto ofNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers.size());
        validateDuplication(numbers);
        return new Lotto(convertToLottoNumber(numbers));
    }

    private static List<LottoNumber> convertToLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (getDistinctNumberCount(numbers) != NUMBER_COUNT) {
            throw new InvalidDuplicatedLottoNumbersException();
        }
    }

    private static long getDistinctNumberCount(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private static void validateNumbersCount(int size) {
        if (size != NUMBER_COUNT) {
            throw new InvalidCountLottoNumbersException();
        }
    }

    public Integer getWinningCount(Lotto lastWonLotto) {
        return (int) lastWonLotto.getNumbers().stream()
                .filter(this::hasNumber)
                .count();
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
