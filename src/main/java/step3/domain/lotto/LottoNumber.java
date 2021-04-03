package step3.domain.lotto;

import step3.exception.LottoNumberOutOfRangeException;

import java.util.HashMap;
import java.util.Map;

public final class LottoNumber {

    private static final Map<Integer, LottoNumber> CACHE;
    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 45;

    private final int lottoNumber;

    static {
        CACHE = new HashMap<>();
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


    private final void validateNumber(int lottoNumber) {
        if (lottoNumber < MINIMUM || MAXIMUM < lottoNumber) {
            throw new LottoNumberOutOfRangeException();
        }
    }

}
