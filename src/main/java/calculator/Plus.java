package calculator;

public class Plus implements ArithmeticOperation {
    @Override
    public Number calculate(Number number1, Number number2) {
        return number1.plus(number2);
    }
}
