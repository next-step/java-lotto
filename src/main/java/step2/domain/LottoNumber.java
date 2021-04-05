package step2.domain;

import step2.exception.IllegalLottoNumberException;

public class LottoNumber {
    public static final int LOTTO_NUMBER_RANGE_MIN = 1;
    public static final int LOTTO_NUMBER_RANGE_MAX = 45;


    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int lottoNumber) {
        lottoNumberValidation(lottoNumber);
        if (LottoNumberCache.cache[lottoNumber] != null)
            return LottoNumberCache.cache[lottoNumber];

        return new LottoNumber(lottoNumber);
    }

    private static void lottoNumberValidation(int lottoNumber) {
        if (lottoNumber < LOTTO_NUMBER_RANGE_MIN
                || lottoNumber > LOTTO_NUMBER_RANGE_MAX)
            throw new IllegalLottoNumberException("1 ~ 45 이내의 숫자만 입력할수 있습니다");
    }

    private static class LottoNumberCache {
        static final int low = LOTTO_NUMBER_RANGE_MIN;
        static final int high = LOTTO_NUMBER_RANGE_MAX;
        static final LottoNumber cache[];

        static {
            cache = new LottoNumber[(high - low) + 2];
            for (int i = 1; i < cache.length; i++) {
                cache[i] = new LottoNumber(i);
            }
        }

        private LottoNumberCache() {
        }
    }
}
