package lotto.domain;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public enum OperatorType {

    ADD("+", new AddStrategy()),
    SUBTRACT("-", new SubtractStrategy()),
    MULTIPLY("*", new MultiplyStrategy()),
    DIVIDE("/", new DivideStrategy());

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
