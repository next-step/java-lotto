package lotto.exception;

public class TicketNumbersCountException extends IllegalArgumentException {
    public TicketNumbersCountException() {
        throw new IllegalArgumentException("Ticket 객체는 항상 6개의 숫자를 가져야만 한다");
    }
}
