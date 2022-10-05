package calculator;

public class Multi implements ArithmeticOperation {
    @Override
    public Number calculate(Number number1, Number number2) {
        return number1.multi(number2);
    }
}
