package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final List<Integer> ALL_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                                                    .boxed()
                                                    .collect(Collectors.toList());

    private final int value;

    public LottoNumber(int value) {
        validateNumberRange(value);
        this.value = value;
    }

    public static LottoNumber from(int number) {
        validateNumberRange(number);
        return new LottoNumber(number);
    }

    private static void validateNumberRange(int value) {
        if (MIN_NUMBER > value || MAX_NUMBER < value) {
            throw new IllegalArgumentException("입력값은 1이상 45이하 입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public Object getValue() {
        return this.value;
    }
}
