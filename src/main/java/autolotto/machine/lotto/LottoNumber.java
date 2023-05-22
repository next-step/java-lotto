package autolotto.machine.lotto;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        checkValidNumber(number);
        this.number = number;
    }

    private void checkValidNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 값이어야 합니다.");
        }
    }

    public int value() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
