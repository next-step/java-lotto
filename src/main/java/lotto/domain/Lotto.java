package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

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
        return List.copyOf(numbers);
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
}
