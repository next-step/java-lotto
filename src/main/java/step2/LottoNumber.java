package step2;

public class LottoNumber {
    public static final String ALERT_OUT_OF_RANGE_OF_LOTTO_NUMBER = "로또번호는 1부터 45까지의 자연수만 가능합니다.";
    private int number;

    private LottoNumber(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(ALERT_OUT_OF_RANGE_OF_LOTTO_NUMBER);
        }
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private boolean isOutOfRange(int number) {
        return number < 1 || number > 45;
    }

    public int getNumber() {
        return number;
    }
}
