package lotto.domain;

import lotto.exception.NotNumberRangeException;
import lotto.strategy.LottoGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public LottoNumbers(LottoGenerator lottoGenerator) {
        List<Integer> numbers = lottoGenerator.lotto();
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberRange(List<Integer> numbers) {
        boolean isNumberRange = numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);

        if (!isNumberRange) {
            throw new NotNumberRangeException();
        }
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));
    }
}
