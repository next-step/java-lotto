package lotto.exception;

import lotto.asset.ExceptionConst;

public class BadMoneyException extends RuntimeException {
    private BadMoneyException() {
        super(ExceptionConst.BAD_MONEY_MSG);
    }

    public static BadMoneyException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadMoneyException instance = new BadMoneyException();
    }
}
