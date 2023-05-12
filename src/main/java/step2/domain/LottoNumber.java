package step2.domain;

import java.util.*;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String INVALID_LOTTO_COUNT_MESSAGE = "로또 번호는 6개의 숫자로 구성되어야 합니다.";
    private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1부터 45까지의 정수 중 하나여야 합니다.";


    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.validateLottoRule(numbers);
        this.numbers = numbers;
    }

    private static void validateLottoCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_COUNT_MESSAGE);
        }
    }

    private static void validateLottoNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_MESSAGE);
                });
    }

    public static void validateLottoRule(List<Integer> numbers) {
        validateLottoCount(numbers);
        validateLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
