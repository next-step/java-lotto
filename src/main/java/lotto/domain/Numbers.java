package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    static final int TOTAL_SIZE_OF_NUMBERS = 6;

    private final List<LottoNumber> numbers;

    Numbers() {
        this.numbers = generatedRandomNumbers();
    }

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = generatedNumbers(numbers);
    }

    List<LottoNumber> getNumbers() {
        return numbers;
    }

    int matchedCount(List<Integer> matchNumbers) {
        return (int) numbers.stream()
                .map(LottoNumber::getNumber)
                .filter(matchNumbers::contains)
                .count();
    }

    private List<LottoNumber> generatedRandomNumbers() {
        return generatedNumbers(LottoGenerator.generateSortedNumbers(TOTAL_SIZE_OF_NUMBERS));
    }

    private List<LottoNumber> generatedNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
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
