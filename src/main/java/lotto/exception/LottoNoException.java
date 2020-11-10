package lotto.exception;

import lotto.asset.ExceptionConst;

public class LottoNoException extends RuntimeException {

    private static final LottoNoException npeException = new LottoNoException(ExceptionConst.NPE_MSG);
    private static final LottoNoException nanException = new LottoNoException(ExceptionConst.NAN_MSG);

    private LottoNoException(String msg) {
        super(msg);
    }

    public static LottoNoException getNpeException() {
        return npeException;
    }

    public static LottoNoException getNanException() {
        return nanException;
    }
}
