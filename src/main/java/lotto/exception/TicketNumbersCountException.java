package lotto.exception;

public class TicketNumbersCountException extends IllegalArgumentException {
    public TicketNumbersCountException() {
        super("Ticket 은 항상 6개의 LottoNumber 를 가져야만 한다. 수동구매의 경우 중복된 숫자를 입력받을 수 없다");
    }
}
