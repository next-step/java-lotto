package calculator.operator;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum OperatorType {

    ADD("+", new AddOperator()),
    MINUS("-", new MinusOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    DIVIDE("/", new DivideOperator());

    private final String operatorStr;
    private final Operator operator;
    private static final Map<String, OperatorType> BY_OPERATOR_STRING = new HashMap<>();

    static {
        for (OperatorType operatorType : values()) {
            BY_OPERATOR_STRING.put(operatorType.operatorStr, operatorType);
        }
    }

    OperatorType(String operatorStr, Operator operator) {
        this.operatorStr = operatorStr;
        this.operator = operator;
    }

    public static OperatorType from(String input) {
        if (!BY_OPERATOR_STRING.containsKey(input)) {
            throw new IllegalArgumentException("wrong operator type");
        }
        return BY_OPERATOR_STRING.get(input);
    }

    public Operator getOperator() {
        return operator;
    }
}
