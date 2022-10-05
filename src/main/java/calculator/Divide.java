package calculator;

public class Divide implements ArithmeticOperation {
    @Override
    public Number calculate(Number number1, Number number2) {
        return number1.divide(number2);
    }
}
