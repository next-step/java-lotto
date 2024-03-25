package domain.lotto;

import java.util.Objects;

public class LottoNumber {
    private final int number;
    private final static int MINIMUM_NUMBER = 1;
    private final static int MAX_NUMBER = 45;
    private final static String RANGE_OVER_EXCEPTION = "1 ~ 45까지의 숫자만 입력 가능합니다.";

    public static LottoNumber from(int number) {
        verifyValidNumberRange(number);
        return new LottoNumber(number);
    }

    private static void verifyValidNumberRange(int number) {
        if (overRange(number)) {
            throw new IllegalArgumentException(RANGE_OVER_EXCEPTION);
        }
    }

    private static boolean overRange(int number) {
        return number < MINIMUM_NUMBER || number > MAX_NUMBER;
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
