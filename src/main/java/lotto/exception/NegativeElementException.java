package lotto.exception;

public class NegativeElementException extends InvalidFormatException {
    public NegativeElementException(String formula) {
        super("음수는 허용되지 않습니다.", formula);
    }
}
