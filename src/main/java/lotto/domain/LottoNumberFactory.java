package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberFactory {
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    private LottoNumberFactory() {
    }

    public static LottoNumber valueOf(Integer i) {
        if (LOTTO_NUMBER_CACHE.containsKey(i)) {
            return LOTTO_NUMBER_CACHE.get(i);
        }

        LottoNumber lottoNumber = new LottoNumber(i);
        LOTTO_NUMBER_CACHE.put(i, lottoNumber);
        return lottoNumber;
    }
}
