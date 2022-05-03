package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberFactory {
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    private LottoNumberFactory() {
    }

    public static LottoNumber valueOf(Integer i) {
        if (lottoNumberCache.containsKey(i)) {
            return lottoNumberCache.get(i);
        }

        LottoNumber lottoNumber = new LottoNumber(i);
        lottoNumberCache.put(i, lottoNumber);
        return lottoNumber;
    }
}
