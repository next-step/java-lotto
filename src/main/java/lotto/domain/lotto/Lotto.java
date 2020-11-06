package lotto.domain.lotto;

import lotto.domain.exception.InvalidCountLottoNumbersException;
import lotto.domain.exception.InvalidRangeLottoNumbersException;

import java.util.List;
import java.util.function.Consumer;

public class Lotto {
    public static final int PRICE = 1000;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;
    private List<Integer> numbers;

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
        numbers.forEach(validateLottoNumber());
    }

    private static Consumer<Integer> validateLottoNumber() {
        return number -> {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new InvalidRangeLottoNumbersException();
            }
        };
    }
}
