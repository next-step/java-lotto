package lotto.model;

import java.util.Objects;

public class LottoNumber {

    public static final int RANGE_MAX = 45;
    public static final int RANGE_MIN = 1;

    private static final LottoNumber[] LOTTO_NUMBERS;
    private static final String RANGE_ERROR_MSG = "번호는 1~45사이의 자연수입니다.";

    static {
        LOTTO_NUMBERS = new LottoNumber[RANGE_MAX + 1];
        for (int num = RANGE_MIN; num <= RANGE_MAX; num++) {
            LOTTO_NUMBERS[num] = new LottoNumber(num);
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateRange(number);
        return LOTTO_NUMBERS[number];
    }

    private static void validateRange(int number) {
        if (number < RANGE_MIN || number > RANGE_MAX) {
            throw new IllegalArgumentException(RANGE_ERROR_MSG);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
