package calculator.operator;

public class Multiply implements Operator {

    @Override
    public int calculate(int number1, int number2) {
        return number1 * number2;
    }
}
