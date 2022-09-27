package calculator.type;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", Integer::sum),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    });

    private static final Map<String, Operator> STORE = new HashMap<>();
    private static final String NOT_SUPPORTED_MESSAGE = "은(는) 지원하지 않는 연산자입니다.";

    static {
        STORE.put(Operator.ADD.stringOperator(), Operator.ADD);
        STORE.put(Operator.SUBTRACT.stringOperator(), Operator.SUBTRACT);
        STORE.put(Operator.MULTIPLY.stringOperator(), Operator.MULTIPLY);
        STORE.put(Operator.DIVIDE.stringOperator(), Operator.DIVIDE);
    }

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operate;

    Operator(String operator, BiFunction<Integer, Integer, Integer> operate) {
        this.operator = operator;
        this.operate = operate;
    }

    public String stringOperator() {
        return operator;
    }

    public int operate(int num1, int num2) {
        return operate.apply(num1, num2);
    }

    public static Operator findOperator(String operator) {
        Operator operatorType = STORE.get(operator);
        if (operatorType == null) {
            throw new IllegalArgumentException(operator + NOT_SUPPORTED_MESSAGE);
        }
        return operatorType;
    }
}
