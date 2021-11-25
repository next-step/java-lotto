package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private final int value;

    /*
        CONSTRUCTOR
     */
    static {
        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int value) {
        this.value = value;
    }

    /*
        INTERFACE
     */
    public static LottoNumber of(int value) {
        validateRange(value);

        return CACHE.get(value);
    }

    /*
        FUNCTION
     */
    private static void validateRange(int value) {
        if (value < LOWER_BOUND || value > UPPER_BOUND) {
            throw new IllegalArgumentException("로또번호는 1이상 45이하입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
