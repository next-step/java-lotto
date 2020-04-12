package lotto.exception;

public class InvalidFormatException extends IllegalArgumentException {
    public InvalidFormatException(String input) {
        super("유효하지 않은 입력 값 입니다. : [" + input + "]");
    }
    public InvalidFormatException(String msg, String input) {
        super(msg + " : [" + input + "]");
    }
}
