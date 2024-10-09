package calculator.domain;

public class MultiplyOperator implements OperatorMethod {
    @Override
    public int operate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
