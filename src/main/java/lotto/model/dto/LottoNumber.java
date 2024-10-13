package lotto.model.dto;

import java.util.Objects;

public class LottoNumber {
    public static final String LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER = "로또번호는 1~45 사이의 정수값만 허용됩니다.";
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ALLOWED_BETWEEN_1_TO_45_INTEGER);
        }
        this.number = number;
    }

    public int compareTo(LottoNumber another) {
        return Integer.compare(this.number, another.number);
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
