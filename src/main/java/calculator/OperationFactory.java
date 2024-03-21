package calculator;

import calculator.operator.Add;
import calculator.operator.Divide;
import calculator.operator.Minus;
import calculator.operator.Multiply;
import calculator.operator.Operator;
import java.util.HashMap;
import java.util.Map;

public class OperationFactory {

    private static final Map<String, Operator> operationMap = new HashMap<>();

    static {
        operationMap.put("+", new Add());
        operationMap.put("-", new Minus());
        operationMap.put("*", new Multiply());
        operationMap.put("/", new Divide());
    }

    public static Operator getOperator(String operator) {
        if (operationMap.containsKey(operator)) {
            return operationMap.get(operator);
        }
        throw new IllegalArgumentException("잘못된 기호입니다.");
    }


}
