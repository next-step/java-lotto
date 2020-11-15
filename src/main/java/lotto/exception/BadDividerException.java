package lotto.exception;

public class BadDividerException extends RuntimeException {
    private BadDividerException() {
        super("0보다 큰 양수로만 나눌 수 있습니다.");
    }

    public static BadDividerException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadDividerException instance = new BadDividerException();
    }
}
