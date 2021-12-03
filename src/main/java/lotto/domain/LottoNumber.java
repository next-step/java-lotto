package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 역할: 로또 단일 숫자 원시값 포장
 */
public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private static final Map<Integer, LottoNumber> CACHED_LOTTO_NUMBER = new HashMap<>();

    static {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            CACHED_LOTTO_NUMBER.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("생성할 수 없는 로또 번호입니다");
        }
        return CACHED_LOTTO_NUMBER.get(number);
    }

    public int number() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.signum(this.number - o.number);
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
}
