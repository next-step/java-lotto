package calculator.domain;

public class Multiplication implements Operator{

    private static final String MULTIPLY = "*";

    public int operate(int first, int second) {
        return first * second;
    }

    public boolean supports(String operator) {
        return MULTIPLY.equals(operator);
    }
}
