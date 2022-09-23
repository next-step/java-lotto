package arithmetic.operator;

public class Division implements Operation {
    static final Number ZERO = new Number(0);

    @Override
    public Number compute(Number number1, Number number2) {
        if (number2 == ZERO) {
            throw new UnsupportedOperationException("Cannot be divided into zero.");
        }
        return number1.divide(number2);
    }
}
