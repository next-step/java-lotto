package lotto.exceptions;

public class DuplicateLottoNumberException extends IllegalArgumentException {
    private static final String MESSAGE = "로또 번호는 중복이 될 수 없습니다.";

    public DuplicateLottoNumberException() {
        super(MESSAGE);
    }

    public DuplicateLottoNumberException(String message) {
        super(message);
    }
}
