package lotto.exception;

public class TicketNumbersCountException extends IllegalArgumentException{
    private static final String MESSAGE = "로또는 항상 6개의 숫자를 가져야만 합니다";
    public TicketNumbersCountException() {
        throw new IllegalArgumentException(MESSAGE);
    }
}
