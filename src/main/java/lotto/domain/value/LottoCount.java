package lotto.domain.value;

import lotto.exception.InvalidUnitException;

import java.util.Objects;

public class LottoCount {
    private static final int BASIC_UNIT = 1000;
    private static final int CORRECT_UNIT = 0;

    private final int count;

    private LottoCount(String count) {
        int lottoPrice = Integer.parseInt(count);
        validateUnit(lottoPrice);

        this.count = lottoPrice % BASIC_UNIT;
    }

    public static LottoCount of(String count) {
        return new LottoCount(count);
    }

    private static void validateUnit(int price) {
        if (!isCorrectUnit(price)) {
            throw new InvalidUnitException();
        }
    }

    private static boolean isCorrectUnit(int input) {
        return divideBasicUnit(input) == CORRECT_UNIT;
    }

    private static int divideBasicUnit(int input) {
        return input % BASIC_UNIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
