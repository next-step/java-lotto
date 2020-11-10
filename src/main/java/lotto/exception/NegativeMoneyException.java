package lotto.exception;

import lotto.asset.ExceptionConst;

public class NegativeMoneyException extends RuntimeException {
    private NegativeMoneyException() {
        super(ExceptionConst.NEGATIVE_MONEY_MSG);
    }

    public static NegativeMoneyException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NegativeMoneyException instance = new NegativeMoneyException();
    }
}
