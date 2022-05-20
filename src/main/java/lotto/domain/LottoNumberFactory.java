package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumberFactory {
    private static Map<Integer, LottoNumber> cachedLottoNumbers = new HashMap<>();

    static LottoNumber valueOf(int number) {
        if (!cachedLottoNumbers.containsKey(number)) {
            cachedLottoNumbers.put(number, new LottoNumber(number));
        }

        return cachedLottoNumbers.get(number);
    }
}
