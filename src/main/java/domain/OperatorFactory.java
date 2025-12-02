package domain;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<String, Operator> operators = new HashMap<>();

    static {
        operators.put("+", new Plus());
        operators.put("-", new Substraction());
        operators.put("*", new Multiplication());
        operators.put("/", new Division());
    }

    public static Operator getOperator(String operator) {
        if (!operators.containsKey(operator)) {
            throw new IllegalArgumentException("사칙연산자 기호가 아닙니다");
        }

        return operators.get(operator);
    }

}
