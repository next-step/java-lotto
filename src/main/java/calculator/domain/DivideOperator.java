package calculator.domain;

public class DivideOperator implements OperatorMethod {
    @Override
    public int operate(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalStateException("분모가 0이 될 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }
}
