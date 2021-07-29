package lotto.domain.lotto.exception;

public class InvalidLottoNumberException extends RuntimeException {

    private static final String MESSAGE = "유효하지 않은 로또 번호들 입니다.";

    public InvalidLottoNumberException() {
        super(MESSAGE);
    }
}
