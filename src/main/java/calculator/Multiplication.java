package calculator;

public class Multiplication implements ArithmeticOperation {
    @Override
    public Number calculate(Number number1, Number number2) {
        return number1.multiplication(number2);
    }
}
