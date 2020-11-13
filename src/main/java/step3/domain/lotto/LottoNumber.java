package step3.domain.lotto;

import java.util.Objects;

import static step3.Constant.ERROR_DUPLICATE_NUMBER;
import static step3.Constant.ERROR_OUT_RANGE_NUMBER;

public class LottoNumber {
    public static final int MINIMUM_ANCHOR_POINT = 0;
    public static final int MAXIMUM_ANCHOR_POINT = 45;

    private final int number;

    public LottoNumber(int number) {
        isValid(number);
        this.number = number;
    }

    private void isValid(int number) {
        if (number <= MINIMUM_ANCHOR_POINT || number > MAXIMUM_ANCHOR_POINT) {
            throw new IllegalArgumentException(ERROR_OUT_RANGE_NUMBER);
        }
    }

    public String getString() {
        return String.valueOf(number);
    }

    public static LottoNumber ofBonus(int number, MarkingNumbers markingNumbers) {
        isDuplicate(number, markingNumbers);
        return new LottoNumber(number);
    }

    private static void isDuplicate(int number, MarkingNumbers markingNumbers) {
        if (markingNumbers.contains(new LottoNumber(number))) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER);
        }
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
