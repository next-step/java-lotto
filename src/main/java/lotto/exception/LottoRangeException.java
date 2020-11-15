package lotto.exception;

public class LottoRangeException extends RuntimeException {
    private LottoRangeException() {
        super("로또 번호는 1부터 45까지 입니다.");
    }

    public static LottoRangeException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final LottoRangeException instance = new LottoRangeException();
    }
}
