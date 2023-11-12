package lotto.domain;

import lotto.exception.NotNumberRangeException;
import lotto.strategy.LottoGenerator;

import java.util.List;

public class LottoNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public LottoNumbers(LottoGenerator lottoGenerator) {
        List<Integer> numbers = lottoGenerator.lotto();
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    private void validateNumberRange(List<Integer> numbers){
        boolean isNumberRange = numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);

        if (!isNumberRange) {
            throw new NotNumberRangeException();
        }
    }
}
