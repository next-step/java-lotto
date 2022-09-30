package arithmetic.operator;

public class Subtraction implements Operation {
    @Override
    public Number compute(Number number1, Number number2) {
        return number1.minus(number2);
    }
}

