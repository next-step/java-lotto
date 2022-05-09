package step2.domain;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE = initCache();

    private final int value;

    private LottoNumber(int number) {
        this.value = number;
    }

    private static Map<Integer, LottoNumber> initCache() {
        Map<Integer, LottoNumber> result = new HashMap<>();
        for (int index = MIN; index <= MAX; index++) {
            result.put(index, new LottoNumber(index));
        }
        return result;
    }

    public static LottoNumber from(String text) {
        int key = Integer.parseInt(text);
        if (CACHE.containsKey(key)) {
            return CACHE.get(key);
        }
        throw new IllegalArgumentException("범위를 벗어나는 번호입니다.");
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

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public int compareTo(LottoNumber operand) {
        return Integer.compare(this.value, operand.value);
    }
}
