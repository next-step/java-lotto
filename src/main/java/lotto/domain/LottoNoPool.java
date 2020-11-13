package lotto.domain;

import lotto.asset.LottoConst;
import lotto.utils.validator.LottoNoValidator;

import java.util.HashMap;

/**
 * NOTE: Flyweight 패턴을 적용하여,
 * 불필요한 LottoNo 생성을 막는다.
 */
public class LottoNoPool {
    private HashMap<Integer, LottoNo> lottoNoPool;

    private LottoNoPool() {
        lottoNoPool = new HashMap<>();
        for (int no = LottoConst.NO_MIN; no <= LottoConst.NO_MAX; no++) {
            lottoNoPool.put(no, new LottoNo(no));
        }
    }

    protected static LottoNoPool getInstance() {
        return SingletonHelper.instance;
    }

    protected LottoNo getLottoNo(int no) {
        LottoNoValidator.validateLottoNo(no);
        return lottoNoPool.get(no);
    }

    private static class SingletonHelper {
        private static final LottoNoPool instance = new LottoNoPool();
    }
}
