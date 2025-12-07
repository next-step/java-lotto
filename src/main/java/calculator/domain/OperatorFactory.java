package calculator.domain;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {
    private static final Map<String, Operator> operators = new HashMap<>();

    static {
        operators.put("+", (first, second) -> first.plus(second));
        operators.put("-", new Operator() {
            @Override
            public Number operate(Number first, Number second) {
                return first.substract(second);
            }
        });
        operators.put("*", Number::multiply);
        operators.put("/", new Operator() {
            @Override
            public Number operate(Number first, Number second) {
                return first.divide(second);
            }
        });
    }

    public static Operator getOperator(String operator) {
        if (!operators.containsKey(operator)) {
            throw new IllegalArgumentException("사칙연산자 기호가 아닙니다");
        }

        return operators.get(operator);
    }

}
