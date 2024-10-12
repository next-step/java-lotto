package calculator.exception;

public class DivisionCannotBeZeroException extends ArithmeticException {

    public static final String ERROR_MESSAGE = " 으로 나눌 수 없습니다";

    public DivisionCannotBeZeroException(int operand) {
        super(operand + ERROR_MESSAGE);
    }

}
