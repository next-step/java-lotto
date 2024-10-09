package calculator.domain;

public class PlusOperator implements OperatorMethod {
    @Override
    public int operate(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
