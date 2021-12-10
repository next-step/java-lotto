package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    static final int TOTAL_SIZE_OF_NUMBERS = 6;

    private final List<Number> numbers;

    Numbers() {
        this.numbers = generatedRandomNumbers();
    }

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = generatedNumbers(numbers);
    }

    List<Number> getNumbers() {
        return numbers;
    }

    private List<Number> generatedRandomNumbers() {
        return generatedNumbers(LottoGenerator.generateSortedNumbers(TOTAL_SIZE_OF_NUMBERS));
    }

    private List<Number> generatedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers가 null이 전달되었습니다.");
        }
        if (numbers.size() != TOTAL_SIZE_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자들은 " + TOTAL_SIZE_OF_NUMBERS + "개로 구성되어야합니다.");
        }
    }
}
