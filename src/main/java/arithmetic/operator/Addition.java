package arithmetic.operator;

public class Addition implements Operation {
    @Override
    public Number compute(Number number1, Number number2) {
        return number1.plus(number2);
    }
}
