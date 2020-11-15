package lotto.exception;

public class NpeException extends RuntimeException {
    private NpeException() {
        super("null 객체가 발생했습니다.");
    }

    public static NpeException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final NpeException instance = new NpeException();
    }
}
