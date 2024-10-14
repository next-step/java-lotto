package lotto.domain;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private final int value;

    public LottoNumber(final int value) {
        valid(value);
        this.value = value;
    }

    private void valid(final int value) {
        if (value < LOTTO_MIN_NUMBER || value > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1부터 45까지의 숫자여야 합니다.");
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
        return value;
    }
}
