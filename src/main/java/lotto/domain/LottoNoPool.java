package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNoPool {
    private static final Map<Integer, LottoNo> pool = new HashMap<>();

    static {
        for (int i = LottoNo.MIN; i <= LottoNo.MAX; i++) {
            pool.put(i, new LottoNo(i));
        }
    }

    private LottoNoPool() {}

    public static LottoNo getLottoNo(int no) {
        LottoNo.validate(no);
        return pool.get(no);
    }
}
