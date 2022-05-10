package lotto.exception;

public class WrongLottoMatchCountException extends IllegalArgumentException {
    private static final String MESSAGE = "번호가 잘못되었습니다.";

    public WrongLottoMatchCountException() {
        super(MESSAGE);
    }
}
