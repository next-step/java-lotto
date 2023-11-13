package calculator.operator;

public class MinusOperator implements Operator {

    @Override
    public int calculate(int firstInput, int secondInput) {
        return firstInput - secondInput;
    }
}
