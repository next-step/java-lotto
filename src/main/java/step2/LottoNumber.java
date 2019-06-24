package step2;

public class LottoNumber {
    static final String ALERT_OUT_OF_RANGE_OF_LOTTO_NUMBER = "로또번호는 1부터 45까지의 자연수만 가능합니다.";
    static final int MINIMUM_LOTTO_NUMBER = 1;
    static final int MAXIMUM_LOTTO_NUMBER = 45;
    private int number;

    private LottoNumber(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ALERT_OUT_OF_RANGE_OF_LOTTO_NUMBER);
        }
        this.number = number;
    }

    public static LottoNumber from(Integer number) {
        return new LottoNumber(number);
    }

    private boolean isOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }

    public int getNumber() {
        return number;
    }
}
