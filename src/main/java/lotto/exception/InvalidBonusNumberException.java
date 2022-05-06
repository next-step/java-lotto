package lotto.exception;

public class InvalidBonusNumberException extends RuntimeException {

    public static final String INVALID_BONUS_NUMBER_ERROR_MESSAGE = "당첨번호에 속해있는 번호는 보너스 넘버로 입력할 수 없습니다.";

    public InvalidBonusNumberException() {
        super(INVALID_BONUS_NUMBER_ERROR_MESSAGE);
    }
}
