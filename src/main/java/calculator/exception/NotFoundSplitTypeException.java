package calculator.exception;

public class NotFoundSplitTypeException extends RuntimeException {
    public NotFoundSplitTypeException(String input) {
        super("일치하는 구분자가 없습니다.===" + input);
    }
}
