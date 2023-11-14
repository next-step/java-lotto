package step3.cache;

import step3.domain.LottoMachine;
import step3.domain.LottoNumber;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberCache {

    private static final Map<Integer, LottoNumber> LottoNumberCache = new HashMap<>();

    static {
        for (int i = LottoMachine.NUMBER_BOX_START_NUMBER; i <= LottoMachine.NUMBER_BOX_END_NUMBER; i++) {
            LottoNumberCache.put(i, LottoNumber.of(i));
        }
    }

    public static LottoNumber getLottoNumber(int number) {
        return LottoNumberCache.get(number);
    }

}
