package lotto.exception;

import lotto.asset.ExceptionConst;

public class BadDividerException extends RuntimeException {
    private BadDividerException() {
        super(ExceptionConst.BAD_DIVIDER_MSG);
    }

    public static BadDividerException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadDividerException instance = new BadDividerException();
    }
}
