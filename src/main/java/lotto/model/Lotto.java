package lotto.model;

import lotto.exception.InvalidCountOfLottoException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Number> numbers) {
        numbers = removeDuplicateNumbers(numbers);
        if (numbers.size() != LOTTO_SIZE) {
            throw new InvalidCountOfLottoException(numbers.size());
        }
        return new Lotto(numbers);
    }

    private static List<Number> removeDuplicateNumbers(List<Number> numbers) {
        numbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return numbers;
    }
}
