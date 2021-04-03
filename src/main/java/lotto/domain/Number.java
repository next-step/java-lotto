package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Number {
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    public static final Map<Integer, Number> lottoNumber = new HashMap<>();
    private final int number;

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            lottoNumber.put(i, new Number(i));
        }
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        return Optional.ofNullable(
                lottoNumber.get(number))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%d부터 %d까지 숫자만 입력해 주세요.", LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
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
