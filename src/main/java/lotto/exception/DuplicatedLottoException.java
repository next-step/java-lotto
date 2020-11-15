package lotto.exception;

public class DuplicatedLottoException extends RuntimeException {
    private DuplicatedLottoException() {
        super("로또 번호는 중복될 수 없습니다.");
    }

    public static DuplicatedLottoException getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final DuplicatedLottoException instance = new DuplicatedLottoException();
    }
}
