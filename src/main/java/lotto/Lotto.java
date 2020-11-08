package lotto;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    public static final String INVALID_NUMBERS_SIZE_ERR_MSG = "로또 숫자의 개수가 유효하지 않습니다.";
    public static final String INVALID_NUMBER_RANGE_ERR_MSG = "로또 숫자가 유효범위를 벗어났습니다.";

    private static final int VALID_MIN_NUMBER = 1;
    private static final int VALID_MAX_NUMBER = 45;
    private static final int VALID_NUMBERS_SIZE = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new TreeSet<>(numbers);
        validateState(numbers);
    }

    private void validateState(List<Integer> numbers) {
        validateNumbersSize();
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumbersSize() {
        if (numbers.size() != VALID_NUMBERS_SIZE) {
            throw new IllegalStateException(INVALID_NUMBERS_SIZE_ERR_MSG);
        }
    }

    private void validateNumberRange(Integer number) {
        if (number < VALID_MIN_NUMBER || number > VALID_MAX_NUMBER) {
            throw new IllegalStateException(INVALID_NUMBER_RANGE_ERR_MSG);
        }
    }
}
