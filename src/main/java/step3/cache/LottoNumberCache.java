package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberCache {

    private static final Map<Integer, LottoNumber> LottoNumberCache = new HashMap<>();

    static {
        for (int i = 1; i <= 45; i++) {
            LottoNumberCache.put(i, LottoNumber.of(i));
        }
    }

    public static LottoNumber getLottoNumber(int number) {
        return LottoNumberCache.get(number);
    }

}
