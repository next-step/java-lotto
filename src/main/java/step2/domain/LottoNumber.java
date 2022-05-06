package step2.domain;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<String, LottoNumber> CACHE = initCache();

    private final int value;

    private LottoNumber(int number) {
        this.value = number;
    }

    private static Map<String, LottoNumber> initCache() {
        Map<String, LottoNumber> result = new HashMap<>();
        for (int index = MIN; index <= MAX; index++) {
            result.put(String.valueOf(index), new LottoNumber(index));
        }
        return result;
    }

    public static LottoNumber from(String text) {
        if (CACHE.containsKey(text)) {
            return CACHE.get(text);
        }
        throw new IllegalArgumentException("범위를 벗어나는 번호입니다.");
    }

    public int getValue() {
        return this.value;
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
