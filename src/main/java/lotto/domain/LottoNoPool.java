package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNoPool {
    private static final Map<Integer, LottoNo> pool = new HashMap<>();

    private LottoNoPool() {}

    public static LottoNo getLottoNo(int no) {
        LottoNo.validate(no);
        return pool.getOrDefault(no, cache(no));
    }

    private static LottoNo cache(int no) {
        LottoNo lottoNo = new LottoNo(no);
        pool.put(no, lottoNo);
        return lottoNo;
    }
}
