package lotto.domain;

import lotto.domain.numbers.LottoNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumberCache {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumberCache;

    static {
        lottoNumberCache = new HashMap<>();
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumberCache.put(number, new LottoNumber(number));
        }
    }

    private LottoNumberCache() {
    }

    public static List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumberCache.values());
    }

    public static LottoNumber findByKey(int number) {
        LottoNumber lottoNumber = lottoNumberCache.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d부터 %d까지여야 합니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
        return lottoNumber;
    }
}
