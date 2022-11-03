package calculator.domain;

import calculator.domain.Operator;

import java.util.HashMap;
import java.util.Map;

public class OperatorMap {
    private static final Map<String, Operator> operatorMap = new HashMap<>();

    static {
        operatorMap.put("+", Operator.PLUS);
        operatorMap.put("-", Operator.MINUS);
        operatorMap.put("*", Operator.MULTIPLY);
        operatorMap.put("/", Operator.DIVIDE);
    }

    public static Operator getOperator(String operator) {
        if (!operatorMap.containsKey(operator)) {
            throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        return operatorMap.get(operator);
    }
}
