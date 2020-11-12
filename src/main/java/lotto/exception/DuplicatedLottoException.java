package lotto.exception;

import lotto.asset.ExceptionConst;

public class DuplicatedLottoException extends RuntimeException {
    private DuplicatedLottoException() {
        super(ExceptionConst.DUPLICATED_LOTTO_MSG);
    }

    public static DuplicatedLottoException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final DuplicatedLottoException instance = new DuplicatedLottoException();
    }
}
