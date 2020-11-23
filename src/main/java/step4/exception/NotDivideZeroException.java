package step4.exception;

public class NotDivideZeroException extends ArithmeticException{
    private static final String NOT_DIVIDE_ZERO_EXCEPTION = "0으로 나눌수는 없습니다.";
    public NotDivideZeroException() {
        super(NOT_DIVIDE_ZERO_EXCEPTION);
    }
}
