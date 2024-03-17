package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public enum OperatorType {

    ADD("+", ((number1, number2) -> number1 + number2)),
    SUBTRACT("-", ((number1, number2) -> number1 - number2)),
    MULTIPLY("*", ((number1, number2) -> number1 * number2)),
    DIVIDE("/", ((number1, number2) -> number1 / number2));

    OperatorType(String operator, OperationStrategy strategy) {
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

    public static boolean isContains(String operator) {
        return operatorMap.containsKey(operator);
    }

    public static Set<String> getOperators() {
        return operatorMap.keySet();
    }

}
