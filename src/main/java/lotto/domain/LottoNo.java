package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNo {

    private static final int MIN_VALID_NUMBER = 1;
    private static final int MAX_VALID_NUMBER = 45;
    private static final Map<Integer, LottoNo> cache = new HashMap<>();

    static {
        for (int i = MIN_VALID_NUMBER; i <=MAX_VALID_NUMBER; i++) {
            cache.put(i, new LottoNo(i));
        }
    }

    private int number;

    private LottoNo(int number) {
        if (number < MIN_VALID_NUMBER || MAX_VALID_NUMBER < number) {
            throw new IllegalArgumentException("invalid lotto number: " + number);
        }
        this.number = number;
    }

    public static LottoNo of(int number) {
        if (number < MIN_VALID_NUMBER || MAX_VALID_NUMBER < number) {
            throw new IllegalArgumentException("invalid lotto number: " + number);
        }
        return cache.get(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
