package lotto.domain.lotto;

import lotto.domain.exception.InvalidCountLottoNumbersException;
import lotto.domain.exception.InvalidRangeLottoNumbersException;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int NUMBER_COUNT = 6;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto ofNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers.size());
        validateNumbersRange(numbers);
        return new Lotto(numbers);
    }

    private static void validateNumbersCount(int size) {
        if (size != NUMBER_COUNT) {
            throw new InvalidCountLottoNumbersException();
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(Lotto::validateLottoNumber);
    }

    private static void validateLottoNumber(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidRangeLottoNumbersException();
        }
    }

    public Integer getWinningCount(List<Integer> lastLottoNumbers) {
        return (int) lastLottoNumbers.stream()
                .filter(this::hasNumber)
                .count();
    }

    private boolean hasNumber(Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
