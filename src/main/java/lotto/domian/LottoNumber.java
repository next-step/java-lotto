package lotto.domian;

public class LottoNumber {

    private final int number;
    private static final int LOTTO_MAXIMUM_VALUE = 45;
    private static final int LOTTO_MINIMUM_VALUE = 1;

    public LottoNumber(int number) {
        checkNumberRange(number);
        this.number = number;
    }

    private void checkNumberRange(int number) {
        if (number < LOTTO_MINIMUM_VALUE || number > LOTTO_MAXIMUM_VALUE) {
            throw new IllegalArgumentException("로또숫자는 1 ~ 45 사이의 숫자여야 합니다.");
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

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
