package stringcalc;

import java.util.function.BiFunction;

public enum ArithmeticOperation {
    PLUS("PLUS", Integer::sum),
    MINUS("MINUS", (num1, num2) -> num1 - num2),
    MULTIPLY("MULTIPLY", (num1, num2) -> num1 * num2),
    DIVISION("DIVISION", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> function;

    ArithmeticOperation(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator = operator;
        this.function = function;
    }

    public int execute(int front, int rear) {
        return function.apply(front, rear);
    }

}
