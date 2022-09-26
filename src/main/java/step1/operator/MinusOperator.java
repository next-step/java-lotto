package step1.operator;

public class MinusOperator implements Operator {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
