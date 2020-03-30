package study.lotto.domain.exception;

public class IllegalLottoTicketArgumentException
        extends IllegalArgumentException {
    public IllegalLottoTicketArgumentException(String s) {
        super(s);
    }
}
