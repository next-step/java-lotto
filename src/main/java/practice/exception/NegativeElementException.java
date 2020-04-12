package practice.exception;

public class NegativeElementException extends InvalidFormatException {
    public NegativeElementException(int item) {
        super("음수는 허용되지 않습니다.", String.valueOf(item));
    }
}
