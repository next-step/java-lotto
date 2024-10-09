package calculator.domain;

public class MinusOperator implements OperatorMethod {
    @Override
    public int operate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
