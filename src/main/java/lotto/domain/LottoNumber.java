package lotto.domain;

import lotto.exception.LottoServiceException;

import java.util.HashMap;
import java.util.Map;

class LottoNumber {

    private static Map<Integer, LottoNumber> LOTTO_NUMBER_POOL = new HashMap<>();

    static {
        for (int number = LottoPolicy.LOTTO_MINIMUM_NUMBER; number <= LottoPolicy.LOTTO_MAXIMUM_NUMBER; number++) {
            LOTTO_NUMBER_POOL.put(number, new LottoNumber(number));
        }
    }

    private int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    static LottoNumber of(int value) {
        validateValueRange(value);
        return LOTTO_NUMBER_POOL.get(value);
    }

    private static void validateValueRange(int value) {
        if (value < LottoPolicy.LOTTO_MINIMUM_NUMBER || value > LottoPolicy.LOTTO_MAXIMUM_NUMBER) {
            throw new LottoServiceException(LottoError.WRONG_LOTTO_RANGE);
        }
    }

    int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }
}
