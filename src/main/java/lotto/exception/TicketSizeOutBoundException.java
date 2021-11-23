package lotto.exception;

public class TicketSizeOutBoundException extends IllegalArgumentException {

    private static final String MESSAGE = "로또 티켓은 %d개 여야 합니다.";

    public TicketSizeOutBoundException(int size) {
        super(String.format(MESSAGE, size));
    }

}
