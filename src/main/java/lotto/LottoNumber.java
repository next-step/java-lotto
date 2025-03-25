package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final String NUMBER_EXCEPTION_MESSAGE = "로또 번호는 1~45 사이의 숫자만 허용합니다.";
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
        return CACHE.get(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LottoNumber)) return false;
        LottoNumber other = (LottoNumber) obj;
        return value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
