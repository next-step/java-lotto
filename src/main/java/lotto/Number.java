package lotto;

public class Number {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private int value;

    public Number(int value) {
        if (validateLottoNumber(value)) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    private boolean validateLottoNumber(int value) {
        return MINIMUM_LOTTO_NUMBER > value || value > MAXIMUM_LOTTO_NUMBER;
    }
}
