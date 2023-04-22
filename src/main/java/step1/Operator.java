package step1;

import java.util.function.BiFunction;

public class Operator {

    private final BiFunction<Integer, Integer, Integer> operator;

    public Operator(String current) {
        if (current.equals("+")) {
            this.operator = (i1, i2) -> i1 + i2;
            return;
        }
        if (current.equals("-")) {
            this.operator = (i1, i2) -> i1 - i2;
            return;
        }
        if (current.equals("*")) {
            this.operator = (i1, i2) -> i1 * i2;
            return;
        }
        if (current.equals("/")) {
            this.operator = (i1, i2) -> i1 / i2;
            return;
        }
        throw new IllegalArgumentException();
    }

    public static boolean isOperator(String input) {
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/");
    }

    int calculate(int leftValue, int rightValue) {
        return operator.apply(leftValue, rightValue);
    }

}
