package lotto.domain;

import lotto.utils.validator.LottoNoValidator;

import java.util.HashMap;
import java.util.Optional;

/**
 * NOTE: Flyweight 패턴을 적용하여,
 * 불필요한 LottoNo 생성을 막는다.
 */
public class LottoNoPool {
    private HashMap<Integer, LottoNo> lottoNoPool;

    private LottoNoPool() {
        lottoNoPool = new HashMap<>();
    }

    protected static LottoNoPool getInstance() {
        return SingletonHelper.instance;
    }

    protected LottoNo getLottoNo(int no) {
        LottoNoValidator.validateLottoNo(no);
        return Optional.ofNullable(
                lottoNoPool.get(no)
        ).orElseGet(() -> {
            LottoNo lottoNo = new LottoNo(no);
            lottoNoPool.put(no, lottoNo);
            return lottoNo;
        });
    }

    protected LottoNo getLottoNo(String no) {
        LottoNoValidator.validateLottoNo(no);
        return getLottoNo(
                Integer.parseInt(no)
        );
    }

    private static class SingletonHelper {
        private static final LottoNoPool instance = new LottoNoPool();
    }
}
