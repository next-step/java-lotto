package lotto.exception;

public class BadNumOfLottoNoException extends RuntimeException {
    private BadNumOfLottoNoException() {
        super("로또는 6개의 번호여야 합니다.");
    }

    public static BadNumOfLottoNoException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadNumOfLottoNoException instance = new BadNumOfLottoNoException();
    }
}
