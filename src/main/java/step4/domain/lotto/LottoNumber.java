package step4.domain.lotto;

import step4.exception.LottoNumberOutOfRangeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class LottoNumber implements Comparable<LottoNumber> {

    private static final Map<Integer, LottoNumber> CACHE;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int lottoNumber;

    static {
        CACHE = new TreeMap<>();
        for (int i = MINIMUM; i <= MAXIMUM; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static final LottoNumber valueOf(String lottoNumber) {
        return valueOf(Integer.valueOf(lottoNumber));
    }

    public static final LottoNumber valueOf(int lottoNumber) {
        validateRange(lottoNumber);
        return CACHE.get(lottoNumber);
    }

    private static final void validateRange(int lottoNumber) {
        if (lottoNumber < MINIMUM || lottoNumber > MAXIMUM) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    public static final List<LottoNumber> values() {
        return new ArrayList<>(CACHE.values());
    }

    public final int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }


}
