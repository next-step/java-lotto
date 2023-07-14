package lotto.model;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_START_RANGE = 1;
    private static final int LOTTO_END_RANGE = 45;

    private final int number;

    public LottoNumber(final int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(final int number) {
        if (number < LOTTO_START_RANGE || number > LOTTO_END_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지 이어야합니다.");
        }
    }

    public int getNumber() {
        return this.number;
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
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
