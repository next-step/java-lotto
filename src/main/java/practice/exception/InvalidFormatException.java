package practice.exception;

public class InvalidFormatException extends IllegalArgumentException {
    public InvalidFormatException(String formula) {
        super("유효하지 않은 수식입니다. : [" + formula + "]");
    }

    public InvalidFormatException(String msg, String item) {
        super(msg + " : [" + item + "]");
    }
}
