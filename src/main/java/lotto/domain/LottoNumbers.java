package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class LottoNumbers {

    public static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(final List<LottoNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
        this.numbers.sort(LottoNumbers::compareLottoNumber);
    }

    public static LottoNumbers of(final int... numbers) {
        return new LottoNumbers(mapToLottoNumberList(numbers));
    }

    public LottoNumberMatchCount matchTo(final LottoNumbers other) {
        final int matchedCount = (int) numbers.stream()
            .filter(other.numbers::contains)
            .count();
        return LottoNumberMatchCount.valueOf(matchedCount);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<Integer> getValue() {
        return numbers.stream()
            .sorted(LottoNumbers::compareLottoNumber)
            .map(LottoNumber::intValue)
            .collect(Collectors.toList());
    }

    private static int compareLottoNumber(final LottoNumber number1, final LottoNumber number2) {
        return Integer.compare(number1.intValue(), number2.intValue());
    }

    private static List<LottoNumber> mapToLottoNumberList(final int... numbers) {
        if (numbers == null) {
            return Collections.emptyList();
        }
        return Arrays.stream(numbers)
            .mapToObj(LottoNumber::valueOf)
            .collect(Collectors.toList());
    }

    private static void validateNumbers(final List<LottoNumber> numbers) {
        if (numbers == null) {
            throw new LottoException("numbers cannot be null");
        }
        if (numbers.size() != SIZE) {
            throw new LottoException(String.format("numbers size should be %d", SIZE));
        }

        numbers.forEach(LottoNumbers::validateNumber);

        if (!isUnique(numbers)) {
            throw new LottoException("all numbers should be unique");
        }
    }

    private static void validateNumber(final LottoNumber number) {
        if (number == null) {
            throw new LottoException("number cannot be null");
        }
    }

    private static boolean isUnique(final List<LottoNumber> numbers) {
        return numbers.size() == new HashSet<>(numbers).size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumbers that = (LottoNumbers) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return '{' + "numbers=" + numbers + '}';
    }
}
