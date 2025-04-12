package step1.domain;

import static step1.domain.OperationImpl.*;

import java.util.HashMap;
import java.util.Map;

public class OperationFactory {

    private static final Map<String, Operation> operations = new HashMap<>();

    static {
        operations.put("+", ADDITION);
        operations.put("-", SUBTRACTION);
        operations.put("*", MULTIPLICATION);
        operations.put("/", DIVISION);
    }

    public static Operation getOperation(String operator) {
        Operation operation = operations.get(operator);
        if (operation == null) {
            throw new IllegalArgumentException("정해진 기호만 입력해야 합니다.");
        }
        return operation;
    }
}
