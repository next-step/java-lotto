package lotto.domain;

import static lotto.util.Constant.INVALID_RANGE;
import static lotto.util.Constant.MAX_NUMBER;
import static lotto.util.Constant.MIN_NUMBER;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> cachedLottoNumber = new HashMap<>();
    private final int number;

    public LottoNumber(final int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
        this.number = number;
    }

    public static LottoNumber from(int value) {
        if(cachedLottoNumber.containsKey(value)) {
            return cachedLottoNumber.get(value);
        }
        cachedLottoNumber.put(value, new LottoNumber(value));
        return cachedLottoNumber.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
