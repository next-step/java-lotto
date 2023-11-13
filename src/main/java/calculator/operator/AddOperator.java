package calculator.operator;

public class AddOperator implements Operator{
    @Override
    public int calculate(int firstInput, int secondInput) {
        return firstInput + secondInput;
    }
}
