package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.*;

public class Lotto {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<Integer> lotto;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.lotto = numbers;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_LENGTH_ERROR);
        }
    }

    public static void validateLottoNumberBound(Integer numbers) {
        if (numbers < LOWER_BOUND || numbers > UPPER_BOUND) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_BOUND_ERROR);
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumbersLength(numbers);
        numbers.forEach(Lotto::validateLottoNumberBound);
    }
}
