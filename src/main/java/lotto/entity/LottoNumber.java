package lotto.entity;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public static void validateRange(int numbers) {
        if (numbers < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < numbers) {
            throw new IllegalArgumentException("1 ~ 45 사이의 값을 입력해 주세요");
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
    public int hashCode() {
        return Objects.hash(number);
    }

    public Integer getInteger() {
        return number;
    }
}
