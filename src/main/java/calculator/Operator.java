package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a,b) -> a+b ),
    MULTIPLY("*", (a,b) -> a*b ),
    DIVIDE("/", (a,b) -> a/b ),
    SUBTRACT("-", (a,b) -> a-b );

    private String operator;
    private BiFunction<Integer,Integer,Integer> operationExpression;

    Operator(String operator, BiFunction<Integer,Integer,Integer> operationExpression) {
        this.operator = operator;
        this.operationExpression = operationExpression;
    }

    public String getOperator() {
        return operator;
    }

    public int calculate(int num1, int num2) {
        return operationExpression.apply(num1, num2);
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(Operator -> Operator.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바르지 않은 사칙연산 기호 입니다."));
    }
}
