package lotto.exception;

import lotto.asset.ExceptionConst;

public class NpeException extends RuntimeException {
    private NpeException() {
        super(ExceptionConst.NPE_MSG);
    }

    public static NpeException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NpeException instance = new NpeException();
    }
}
