package cc.oakk.lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final LottoNumberRange RANGE = LottoNumberRange.between(1, 45);
    private static final Map<Integer, LottoNumber> INSTANCES = new HashMap<>();

    private final int number;

    private LottoNumber(int number) {
        if (!RANGE.isValidNumber(number)) {
            throw new IllegalArgumentException(
                    String.format("%d should be between %d and %d", number, RANGE.getFrom(), RANGE.getTo()));
        }
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (INSTANCES.containsKey(number)) {
            return INSTANCES.get(number);
        }
        LottoNumber instance = new LottoNumber(number);
        INSTANCES.put(number, instance);
        return instance;
    }

    @Override
    public String toString() {
        return Integer.valueOf(number).toString();
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

    @Override
    public int compareTo(LottoNumber target) {
        return number - target.number;
    }
}
