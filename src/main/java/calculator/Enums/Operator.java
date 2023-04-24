package calculator.Enums;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> function;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static int execute(int numBefore, String operator, int numAfter) {
        int result = numBefore;

        switch (operator) {
            case "+":
                result = PLUS.function.apply(numBefore, numAfter);
                break;
            case "-":
                result = MINUS.function.apply(numBefore, numAfter);
                break;
            case "*":
                result = MULTIPLE.function.apply(numBefore, numAfter);
                break;
            case "/":
                result = DIVIDE.function.apply(numBefore, numAfter);
                break;
        }
        return result;
    }
}
