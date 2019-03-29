package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    private static final Map<Integer, LottoNumber> cachedLottoNumbers = new HashMap<>();

    static {
        IntStream.range(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .forEach(number -> cachedLottoNumbers.put(number, new LottoNumber(number)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        if (isInvalidNumber(number)) {
            throw new IllegalArgumentException("로또번호는 1~45 사이에 있어야 합니다.");
        }
        return cachedLottoNumbers.get(number);
    }

    private static boolean isInvalidNumber(int number) {
        return number > MAXIMUM_NUMBER || MINIMUM_NUMBER > number;
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
    public String toString() {
        return number + "";
    }
}
