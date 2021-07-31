package lotto.domain;

import lotto.exception.OutOfRangeException;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    private static final List<LottoNumber> TEMPLATE = Collections.unmodifiableList(
            IntStream.range(MIN_VALUE, MAX_VALUE + 1)
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toList())
    );

    private final int value;

    private LottoNumber(int value) {
        validateNumberRange(value);

        this.value = value;
    }

    private static void validateNumberRange(int value) {
        if (value < 1 || value > 45) {
            throw new OutOfRangeException("로또 번호는 1부터 45까지의 숫자만 유효합니다.");
        }
    }

    public static LottoNumber of(int value) {
        validateNumberRange(value);

        int index = value - 1;
        return TEMPLATE.get(index);
    }

    @Override
    public boolean equals(Object compareValue) {
        if (!(compareValue instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) compareValue;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber compareValue) {
        return Integer.compare(value, compareValue.value);
    }
}
