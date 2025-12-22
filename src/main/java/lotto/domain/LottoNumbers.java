package lotto.domain;

import lotto.util.LottoNumberParser;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(int... numbers) {
        this(LottoNumberParser.parse(numbers));
    }

    public LottoNumbers(String numbers) {
        this(LottoNumberParser.parse(numbers));
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int getMatchCount(LottoNumbers other) {
        int matchCount = 0;

        for (LottoNumber number : numbers) {
            if (other.contains(number)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
