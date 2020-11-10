package lotto.exception;

import lotto.asset.ExceptionConst;

public class BadPriceException extends RuntimeException {
    private BadPriceException() {
        super(ExceptionConst.BAD_PRICE_MSG);
    }

    public static BadPriceException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadPriceException instance = new BadPriceException();
    }
}
