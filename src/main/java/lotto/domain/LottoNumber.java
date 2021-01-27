package lotto.domain;

public class LottoNumber {
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;
    private final int number;

    public LottoNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < MINIMUM || number > MAXIMUM) {
            throw new IllegalArgumentException("정상적인 수의 범위가 아닙니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}