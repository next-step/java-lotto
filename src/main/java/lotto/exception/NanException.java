package lotto.exception;

public class NanException extends RuntimeException {
    private NanException() {
        super("숫자가 아닙니다.");
    }

    public static NanException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NanException instance = new NanException();
    }
}
