package StringCalculator.backend.domain;

import java.util.Map;

public class OperatorFactory {

    private static final Map<String, Operator> OPERATORS = Map.of(
            "+", new PlusOperator(),
            "-", new MinusOperator(),
            "*", new MultiplyOperator(),
            "/", new DivideOperator()
    );

    public static Operator getOperator(String symbol) {
        checkContains(symbol);
        return OPERATORS.get(symbol);
    }

    private static void checkContains(String symbol) {
        if (!OPERATORS.containsKey(symbol)) {
            throw new IllegalArgumentException("[" + symbol + "] 지원하지 않는 연산 기호입니다.");
        }
    }
}
