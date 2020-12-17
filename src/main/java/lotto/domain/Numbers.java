package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    public static final int TOTAL_NUMBER_SIZE = 6;

    private final List<Number> numbers;

    Numbers() {
        this.numbers = createRandomNumbers();
    }

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = createNumbers(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TOTAL_NUMBER_SIZE) {
            throw new IllegalArgumentException("숫자들은 " + TOTAL_NUMBER_SIZE + "개로 구성되어야합니다.");
        }
    }

    private List<Number> createRandomNumbers() {
        return createNumbers(LottoGenerator.generateRandomNumbers());
    }

    private List<Number> createNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    List<Number> getNumbers() {
        return numbers;
    }
}
