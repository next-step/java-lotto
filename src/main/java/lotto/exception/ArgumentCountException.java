package lotto.exception;

public class ArgumentCountException extends IllegalArgumentException {

    private static final String MESSAGE = "티켓 번호는 %d개가 존재해야 합니다.";

    public ArgumentCountException(Integer ticketNumberCount) {
        super(String.format(MESSAGE, ticketNumberCount));
    }

}
