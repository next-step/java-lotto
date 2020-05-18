package lotto.exception;

public class InputValueException extends RuntimeException {

    public InputValueException() {
        super("구입금액을 1000원보다 작게 입력할 수 없습니다.");
    }
}
