package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final List<LottoNumber> CACHED_NUMBERS;

    private Integer number;

    static {
        CACHED_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        validateRange(number);
        return CACHED_NUMBERS.get(number - 1);
    }

    private static void validateRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 45 범위를 벗어나는 숫자를 포함하고 있습니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number.toString();
    }
}
