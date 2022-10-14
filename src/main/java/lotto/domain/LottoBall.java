package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBall {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int number;

    public LottoBall(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public boolean hasSameNumber(int number) {
        return this.number == number;
    }

    private static void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER && number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                    "로또 숫자는 " +
                    MIN_LOTTO_NUMBER + "부터 " +
                    MAX_LOTTO_NUMBER + "까지의 숫자여야만 합니다.");
        }
    }

}
