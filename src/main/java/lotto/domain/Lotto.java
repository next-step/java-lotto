package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    private static final String IS_NULL_OR_NOT_SIX_ERROR_MESSAGE = "6개의 숫자를 등록해야 합니다.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "1부터 45 사이의 숫자를 등록해야 합니다.";
    private static final int LIMIT_SIZE = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public Lotto(List<Integer> numbers) {
        validateNumber(numbers);
        this.numbers = numbers;
    }

    private void validateNumber(List<Integer> numbers) {
        if(isNullOrEmpty(numbers) || numbers.size() != LIMIT_SIZE) {
            throw new IllegalArgumentException(IS_NULL_OR_NOT_SIX_ERROR_MESSAGE);
        }
        if(checkDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
        if(checkNumbersRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }

    private boolean isNullOrEmpty(List<Integer> numbers) {
        return numbers == null || numbers.isEmpty();
    }

    private boolean checkDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    private boolean checkNumbersRange(List<Integer> numbers) {
        long count = numbers.stream()
                .filter(number -> number < MIN_VALUE || number > MAX_VALUE)
                .count();
        return count >= MIN_VALUE;
    }

}
