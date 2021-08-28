package lotto;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int SAVED_MIN_NUMBER = 1;
    private static final int SAVED_MAX_NUMBER = 45;

    private static final String LOTTO_NUMBERS_INVALID_SIZE_ERROR_MESSAGE = "로또 번호의 개수는 6개가 들어와야 한다.";
    private static final String LOTTO_NUMBERS_INVALID_DUPLICATE_ERROR_MESSAGE = "로또의 번호는 중복되어 저장될 수 없다.";
    private static final String LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE = "로또 번호는 1이상 45이하의 수만 들어올 수 있다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkLottoNumbersSize(numbers);
        checkDuplicatedNumber(numbers);
        checkNumberRange(numbers);

        this.numbers = numbers;
    }

    private static void checkLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void checkNumberRange(List<Integer> numbers) {
        if (numbers.stream().filter(num -> num >= SAVED_MIN_NUMBER && num <= SAVED_MAX_NUMBER).count() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_INVALID_RANGE_ERROR_MESSAGE);
        }
    }

}
