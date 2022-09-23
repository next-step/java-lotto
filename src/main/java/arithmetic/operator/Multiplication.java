package arithmetic.operator;

public class Multiplication implements Operation {
    @Override
    public Number compute(Number number1, Number number2) {
        return number1.multiply(number2);
    }
}
