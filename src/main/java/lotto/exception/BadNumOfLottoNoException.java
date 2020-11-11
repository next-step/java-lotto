package lotto.exception;

import lotto.asset.ExceptionConst;

public class BadNumOfLottoNoException extends RuntimeException {
    private BadNumOfLottoNoException() {
        super(ExceptionConst.BAD_NUM_OF_LOTTO_NO_MSG);
    }

    public static BadNumOfLottoNoException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadNumOfLottoNoException instance = new BadNumOfLottoNoException();
    }
}
