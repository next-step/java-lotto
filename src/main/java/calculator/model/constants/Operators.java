package calculator.model.constants;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operators {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operators(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }
    public static int calculate(String operator, int num1, int num2){
        return operator(operator).expression.apply(num1, num2);
    }
    // 이 부분에서 Exception Handling?
    public static Operators operator(String operator){
        return Arrays.stream(values()).filter(operators -> operators.operator.equals(operator))
                .findAny().get();
    }

}
