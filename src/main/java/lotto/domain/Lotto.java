package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this(LottoFactory.generateLotto());
    }

    public Lotto(Integer... numbers) {
        this(Arrays.asList(numbers));
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if (noDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }

        boolean invalidNumber = numbers.stream()
                .anyMatch(n -> n < 1 || n > 45);
        if (invalidNumber) {
            throw new IllegalArgumentException();
        }

    }
}
