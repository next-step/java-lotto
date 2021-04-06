package step4.domain.lotto;

import step4.exception.LottoNumberOutOfRangeException;

import java.util.Map;
import java.util.TreeMap;

public final class LottoNumber {

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

    public final static LottoNumber valueOf(int lottoNumber) {
        validateRange(lottoNumber);
        return CACHE.get(lottoNumber);
    }

    private static final void validateRange(int lottoNumber) {
        if (lottoNumber < MINIMUM || lottoNumber > MAXIMUM) {
            throw new LottoNumberOutOfRangeException();
        }
    }

}
