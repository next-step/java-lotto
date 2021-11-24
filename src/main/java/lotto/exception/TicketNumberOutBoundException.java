package lotto.exception;

public class TicketNumberOutBoundException extends IllegalArgumentException {

    private static final String MESSAGE = "%d ~ %d 값만 입력할 수 있습니다.";

    public TicketNumberOutBoundException(Integer start, Integer end) {
        super(String.format(MESSAGE, start, end));
    }

}
