package calculator.operator;

public class Add implements Operator {

    @Override
    public int calculate(int number1, int number2) {
        return number1 + number2;
    }
}
