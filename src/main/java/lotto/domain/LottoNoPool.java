package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNoPool {
    private final Map<Integer, LottoNo> lottoNoPool;

    private LottoNoPool() {
        lottoNoPool = new HashMap<>();
        for (int no = LottoNo.MIN; no <= LottoNo.MAX; no++) {
            lottoNoPool.put(no, new LottoNo(no));
        }
    }

    static LottoNoPool getInstance() {
        return SingletonHelper.instance;
    }

    LottoNo getLottoNo(int no) {
        LottoNo.validate(no);
        return lottoNoPool.get(no);
    }

    private static class SingletonHelper {
        private static final LottoNoPool instance = new LottoNoPool();
    }
}
