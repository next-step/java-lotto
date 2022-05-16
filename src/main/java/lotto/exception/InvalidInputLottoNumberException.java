package lotto.exception;

public class InvalidInputLottoNumberException extends RuntimeException {

    public static final String INVALID_WINNING_NUMBER_MESSAGE = "로또번호 입력이 잘못되었습니다.";

    public InvalidInputLottoNumberException() {
        super(INVALID_WINNING_NUMBER_MESSAGE);
    }
}
