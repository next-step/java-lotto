package lotto.exception;

import lotto.asset.ExceptionConst;

public class LottoRangeException extends RuntimeException {
    private LottoRangeException() {
        super(ExceptionConst.LOTTO_RANGE_MSG);
    }

    public static LottoRangeException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final LottoRangeException instance = new LottoRangeException();
    }
}
