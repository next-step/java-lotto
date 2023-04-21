package Calculator.Enums;

import java.util.function.BiFunction;

public enum OperatorEnum {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLE("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> function;

    OperatorEnum(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static int execute(Integer numBefore, String operator, Integer numAfter) {
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
