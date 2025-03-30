package step4.lotto.model;

import java.util.HashMap;
import java.util.Map;
import step4.lotto.exception.LottoNumberException;

public class LottoNumber implements Comparable<LottoNumber> {

    public final static int MIN_VALUE = 1;
    public final static int MAX_VALUE = 45;
    private final int value;

    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();
    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    public LottoNumber(int value) {
        validateLottoNumber(value);
        this.value = value;
    }

    public static LottoNumber of(int value) {
        validateLottoNumber(value);
        return CACHE.get(value);
    }

    public static LottoNumber of(String value) {
        validateLottoNumber(value);
        return CACHE.get(Integer.parseInt(value));
    }

    private static void validateLottoNumber(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new LottoNumberException();
        }
    }

    private static void validateLottoNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new LottoNumberException();
        }
        validateLottoNumber(Integer.parseInt(value));
    }

    public int value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            return value == ((LottoNumber) obj).value;
        }
        return false;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

}
