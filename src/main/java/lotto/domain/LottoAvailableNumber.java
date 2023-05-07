package lotto.domain;

public class LottoAvailableNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoAvailableNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoAvailableNumber that = (LottoAvailableNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    String.format("로또 번호는 %d ~ %d 사이의 숫자만 가능합니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            );
        }
    }
}
