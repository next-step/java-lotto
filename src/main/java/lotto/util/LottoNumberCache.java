package lotto.util;

import lotto.domain.LottoNumber;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberCache {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final LottoNumber NONE = new LottoNumber(0);
    private static final Map<Integer, LottoNumber> Cache = new HashMap<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            Cache.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber get(int value) {
        LottoNumber lottoNumber = Cache.getOrDefault(value, NONE);
        if (lottoNumber == NONE) {
            throw new IllegalArgumentException("로또의 숫자는 1에서 45 사이여야합니다.");
        }
        return Cache.get(value);
    }

    public static LottoNumber get(String value) {
        return get(Integer.parseInt(value));
    }
}
