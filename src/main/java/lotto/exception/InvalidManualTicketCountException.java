package lotto.exception;

public class InvalidManualTicketCountException extends RuntimeException {

    public static final String MESSAGE = "수동 구매 수가 구입 금액 한도치를 넘었습니다.";

    public InvalidManualTicketCountException() {
        this(MESSAGE);
    }

    public InvalidManualTicketCountException(String message) {
        super(message);
    }

    public InvalidManualTicketCountException(String message, Throwable cause) {
        super(message, cause);
    }
}
