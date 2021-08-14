package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static final List<LottoNumber> lottoNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private final int number;

    public LottoNumber(final int number) {
        this.number = number;
        validateNumberRange();
    }

    public LottoNumber(final String stringNumber) {
        this.number = parseInt(stringNumber);
        validateNumberRange();
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid string input: " + number);
        }
    }

    private void validateNumberRange() {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("cannot be less than " + MIN_NUMBER);
        }
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException("cannot be greater than " + MAX_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return number - o.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
