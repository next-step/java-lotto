package lotto.domain;


import java.util.HashMap;
import java.util.Map;

public enum Operator {

    ADD("+", ((number1, number2) -> number1 + number2)),
    SUBTRACT("-", ((number1, number2) -> number1 - number2)),
    MULTIPLY("*", ((number1, number2) -> number1 * number2)),
    DIVIDE("/", ((number1, number2) -> number1 / number2));

    Operator(String operator, OperationStrategy strategy) {
        this.operator = operator;
        this.strategy = strategy;
    }

    private final String operator;
    private final OperationStrategy strategy;

    private static final Map<String, OperationStrategy> operatorMap = new HashMap<>() {{
        put(ADD.operator, ADD.strategy);
        put(SUBTRACT.operator, SUBTRACT.strategy);
        put(MULTIPLY.operator, MULTIPLY.strategy);
        put(DIVIDE.operator, DIVIDE.strategy);
    }};

    public static OperationStrategy getStrategy(String operator) {
        return operatorMap.get(operator);
    }

}
