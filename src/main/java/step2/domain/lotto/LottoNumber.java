package step2.domain.lotto;

public class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        if (number < LottoConstants.MIN_LOTTO_NUMBER || number > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Lotto number must be between " + LottoConstants.MIN_LOTTO_NUMBER + " and " + LottoConstants.MAX_LOTTO_NUMBER);
        }
        this.number = number;
    }

    public int value() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof LottoNumber)) return false;

        return this.number == ((LottoNumber) obj).value();
    }
}
