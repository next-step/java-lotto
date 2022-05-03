package lotto.exception;

public class InvalidLottoTicketException extends RuntimeException{

    public static final String INVALID_LOTTO_ERROR_MESSAGE = "로또 숫자의 갯수는 6개여야 합니다.";

    public InvalidLottoTicketException() {
        super(INVALID_LOTTO_ERROR_MESSAGE);
    }
}
