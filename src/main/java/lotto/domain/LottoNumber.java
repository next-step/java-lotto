package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final int value;

    public LottoNumber(int value) {

        validateLottoRange(value);

        this.value = value;
    }

    public LottoNumber(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자만 가능합니다.");
        }

        this.value = number;
    }

    private static void validateLottoRange(int value) {
        if (value < LOTTO_MIN_NUMBER || value > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 가능합니다.");
        }
    }

    public String findNumber() {
        return String.valueOf(value);
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
}
