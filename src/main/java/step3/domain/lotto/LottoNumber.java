package step3.domain.lotto;

import step3.exception.LottoNumberOutOfRangeException;

import java.util.*;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> CACHE;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int lottoNumber;

    static {
        CACHE = new TreeMap<>();
        for (int i = MINIMUM; i <= MAXIMUM; i++) {
            CACHE.put(i, valueOf(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static final LottoNumber valueOf(int lottoNumber) {
        if (CACHE.containsKey(lottoNumber)) {
            return CACHE.get(lottoNumber);
        }
        return new LottoNumber(lottoNumber);
    }

    public static final List<LottoNumber> values() {
        return new ArrayList<>(CACHE.values());
    }

    private final void validateNumber(int lottoNumber) {
        if (lottoNumber < MINIMUM || MAXIMUM < lottoNumber) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
