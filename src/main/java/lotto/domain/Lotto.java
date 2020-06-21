package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String COMMA_SPACE = ", ";
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {

        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        return checkNumbers.size() != LOTTO_SIZE;
    }

    @Override
    public String toString() {
        return "[" + numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.joining(COMMA_SPACE))+ "]";
    }
}
