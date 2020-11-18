package lotto.exception;

public class BadNumOfManualLottosException extends RuntimeException {
    private BadNumOfManualLottosException() {
        super("수동으로 구매할 로또 수가 구입금액을 초과했습니다.");
    }

    public static BadNumOfManualLottosException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadNumOfManualLottosException instance = new BadNumOfManualLottosException();
    }
}
