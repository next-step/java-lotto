package lotto.domain;

import java.util.List;

public class LottoNumber {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    private final int number;

    public LottoNumber(int number) {
        assertValidRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void assertValidRange(int number) {
        String errorMessage = String.format("[로또] 숫자의 범위는 %d 부터 %d까지 입니다.", MIN_NUMBER, MAX_NUMBER);

        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
