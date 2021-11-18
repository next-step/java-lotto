package lotto.exception;

public class ArgumentNumberException extends IllegalArgumentException {

    private static final String MESSAGE = "티켓의 번호는 %d ~ $d 사이여야 합니다.";

    public ArgumentNumberException(Integer minimum, Integer maximum) {
        super(String.format(MESSAGE, minimum, maximum));
    }

}
