package lotto.exception;

import lotto.asset.ExceptionConst;

public class NanException extends RuntimeException {
    private NanException() {
        super(ExceptionConst.NAN_MSG);
    }

    public static NanException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NanException instance = new NanException();
    }
}
