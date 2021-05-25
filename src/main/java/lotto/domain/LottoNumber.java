package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 로또 번호.
 */
public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBER = "로또는 1과 45사이의 숫자만 가능합니다.";

    private static final Map<Integer, LottoNumber> cachedLottoNumbers = new HashMap<>();

    static {
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            cachedLottoNumbers.put(i, new LottoNumber(i));
        }
    }

    /**
     * 로또 번호.
     */
    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER);
        }
        return cachedLottoNumbers.get((number));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
