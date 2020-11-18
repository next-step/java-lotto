package humbledude.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    private static final Map<Integer, LottoNumber> NUMBER_MAP = new HashMap<>();

    private final int number;

    static {
        IntStream.rangeClosed(LOTTO_MIN, LOTTO_MAX)
                .forEach(number -> NUMBER_MAP.put(number, new LottoNumber(number)));
    }

    private LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validateNumber(number);
        return NUMBER_MAP.get(number);
    }

    public int getNumber() {
        return number;
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException("로또는 " + LOTTO_MIN + "부터 " + LOTTO_MAX + "까지의 숫자만 쓸 수 있어요");
        }
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
    public int compareTo(LottoNumber that) {
        return this.number - that.number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
