package calculator;

public class Minus implements ArithmeticOperation {
    @Override
    public Number calculate(Number number1, Number number2) {
        return number1.minus(number2);
    }
}
