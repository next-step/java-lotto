package lotto.domain;

import lotto.exception.NotNumberRangeException;
import lotto.strategy.LottoGenerator;

import java.util.List;
import java.util.Objects;
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
        if (!isNumberRange(numbers)) {
            throw new NotNumberRangeException();
        }
    }

    private boolean isNumberRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    public long matchCount(LottoWinNumbers lottoWinNumbers) {
        return lottoWinNumbers.matchCount(numbers);
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
