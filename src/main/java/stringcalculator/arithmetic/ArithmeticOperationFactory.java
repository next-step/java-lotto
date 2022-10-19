package stringcalculator.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticOperationFactory {

    private static final Map<String, ArithmeticOperation> OPERATION_MAP = new HashMap<>();
    static {
        OPERATION_MAP.put("+", new Add());
        OPERATION_MAP.put("-", new Sub());
        OPERATION_MAP.put("*", new Multiply());
        OPERATION_MAP.put("/", new Divide());
    }

    public ArithmeticOperation getOperation(String arithmetic) {
        ArithmeticOperation operation = OPERATION_MAP.get(arithmetic);
        validateSupports(operation, arithmetic);
        return operation;
    }

    private void validateSupports(ArithmeticOperation operation, String arithmetic) {
        if (operation == null) {
            throw new IllegalArgumentException(arithmetic + "는 지원되는 연산자가 아닙니다");
        }
    }
}
