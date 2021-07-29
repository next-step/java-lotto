package lotto.domain;

public class LottoNumber {
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String FAIL_MESSAGE = "1-45 사이의 값을 입력해주세요.";

    private int value;

    LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(FAIL_MESSAGE);
        }
    }
}
