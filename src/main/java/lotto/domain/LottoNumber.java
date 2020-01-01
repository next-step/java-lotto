package lotto.domain;

import java.util.HashMap;
import java.util.Map;

class LottoNumber {

    private static Map<Integer, LottoNumber> LOTTO_NUMBER_POOL = new HashMap<>();

    static {
        for (int i = LottoPolicy.LOTTO_MINIMUM_NUMBER; i <= LottoPolicy.LOTTO_MAXIMUM_NUMBER; i++) {
            LOTTO_NUMBER_POOL.put(i, new LottoNumber(i));
        }
    }

    private int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    static LottoNumber of(int value) {
        return LOTTO_NUMBER_POOL.get(value);
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
