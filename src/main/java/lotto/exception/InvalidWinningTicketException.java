package lotto.exception;

public class InvalidWinningTicketException extends RuntimeException {

    public static final String INVALID_BONUS_BALL = "보너스 볼이 당첨 번호에 포함되어 있습니다.";

    public InvalidWinningTicketException() {
        this(INVALID_BONUS_BALL);
    }

    public InvalidWinningTicketException(String message) {
        super(message);
    }
}
