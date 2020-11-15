package lotto.exception;

public class BadShuffleException extends RuntimeException {
    private BadShuffleException() {
        super("shuffle 의 범위를 초과했습니다.");
    }

    public static BadShuffleException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BadShuffleException instance = new BadShuffleException();
    }
}
