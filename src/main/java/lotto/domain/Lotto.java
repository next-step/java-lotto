package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String DELIMITER_COMMA = ", ";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDistinct(numbers);
        this.numbers = numbers;
    }

    public static Lotto createFrom(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generate());
    }

    public List<Integer> getNumbers() {
        return List.copyOf(this.numbers)
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }
    }

    private void validateDistinct(List<Integer> numbers) {
        long count = numbers.stream()
            .distinct()
            .count();
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    @Override
    public String toString() {
        return getNumbers().stream()
            .map(String::valueOf)
            .collect(Collectors.joining(DELIMITER_COMMA));
    }
}
