package step1.domain;

import static step1.domain.OperationImpl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * OperationFactory 클래스는 연산자에 따라 적절한 Operation 구현체를 반환하는 팩토리 클래스입니다.
 */
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
