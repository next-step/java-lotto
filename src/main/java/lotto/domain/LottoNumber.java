package lotto.domain;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    public static final int RETURN_ONE = 1;
    public static final int RETURN_ZERO = 0;

    private final int number;

    public LottoNumber(int number) {
        if(number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    private int getNumber() {
        return number;
    }

    public int compareNumber(LottoNumber lottoNumber) {
        if(number == lottoNumber.getNumber()) {
            return RETURN_ONE;
        }
        return RETURN_ZERO;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
