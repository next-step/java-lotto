package step1;

import java.util.function.BiFunction;

public enum OperatorCaculate {
    PLUS("+", (x, y) -> x + y),
    SUB("-", (x, y) -> x - y),
    DIVIDE("/", (x, y) -> x / y),
    MULTIPLE("*", (x, y) -> x * y);


    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;
    OperatorCaculate(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public int caclulate(int x, int y) {
        return expression.apply(x, y);
    }

}
