package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    public LottoNumber(final int number) {
        validateNumberRange(number);
        this.number = number;
    }

    public LottoNumber(final String number) {
        this(Integer.parseInt(number));
    }

    public static List<LottoNumber> all() {
        return IntStream.rangeClosed(MIN, MAX)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateNumberRange(final int number) {
        if (number < MIN || MAX < number) {
            throw new IllegalArgumentException("1부터 45까지 정수만 입력 가능합니다");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
