package calculator.operator;

public class MultiplyOperator implements Operator {
    @Override
    public int calculate(int firstInput, int secondInput) {
        return firstInput * secondInput;
    }
}
