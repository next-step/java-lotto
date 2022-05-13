package lotto.exception;

public class InvalidLottoTicketSizeException extends RuntimeException{
    private static final String INVALID_LOTTO_TICKET_SIZE__MESSAGE = "로또는 6개의 번호로 구성되어야합니다.";
    public InvalidLottoTicketSizeException(){
        super(INVALID_LOTTO_TICKET_SIZE__MESSAGE);
    }
}
