package operations;

public class Multiplication implements CalculateStrategy {
    private static final String MATCH_STRING = "*";

    @Override
    public boolean match(String operation) {
        return MATCH_STRING.equals(operation);
    }

    @Override
    public int calculate(Number number1, Number number2) {
        return number1.multiply(number2);
    }
}
