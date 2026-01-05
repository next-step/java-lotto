package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            cache.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber valueOf(int value) {
        return Optional.ofNullable(cache.get(value))
                .orElseThrow(() -> new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다."));
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber number = (LottoNumber) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
