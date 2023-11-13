package calculator.operator;

public class DivideOperator implements Operator {

    @Override
    public int calculate(int firstInput, int secondInput) {
        return firstInput / secondInput;
    }
}
