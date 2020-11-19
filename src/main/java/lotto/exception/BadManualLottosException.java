package lotto.exception;

public class BadManualLottosException extends RuntimeException {
    private BadManualLottosException() {
        super("수동으로 구매할 로또 수와 수동으로 구매한 로또 수가 같아야 한다.");
    }

    public static BadManualLottosException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadManualLottosException instance = new BadManualLottosException();
    }
}
