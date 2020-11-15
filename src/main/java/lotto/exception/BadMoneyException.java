package lotto.exception;

public class BadMoneyException extends RuntimeException {
    private BadMoneyException() {
        super("money 는 0보다 큰 양수여야 합니다.");
    }

    public static BadMoneyException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadMoneyException instance = new BadMoneyException();
    }
}
