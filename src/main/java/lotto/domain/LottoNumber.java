package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public static final List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber from(int value) {
        verify(value);
        return LOTTO_NUMBERS.get(toIndex(value));
    }

    public int getValue() {
        return value;
    }

    private static int toIndex(int value) {
        return value - 1;
    }

    private static void verify(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("1에서 45사이의 숫자만 선택할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(LottoNumber number) {
        return this.value - number.value;
    }
}
