package calculator.domain;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

enum Operation {

    ADD("+", Integer::sum),

    SUBTRACT("-", (operand1, operand2) -> operand1 - operand2),

    MULTIPLY("*", (operand1, operand2) -> operand1 * operand2),

    DIVIDE("/", (operand1, operand2) -> {
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return operand1 / operand2;
    });

    private final String symbol;
    private final IntBinaryOperator operator;

    Operation(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    static IntBinaryOperator findOperatorBySymbol(String symbol) {
        if (StringUtil.isEmpty(symbol)) {
            throw new IllegalArgumentException("기호를 입력해 주세요.");
        }

        return Arrays.stream(values())
                .filter(operation -> hasSymbol(operation, symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용할 수 없는 연산자입니다. : " + symbol))
                .operator;
    }

    private static boolean hasSymbol(Operation operation, String symbol) {
        return operation.symbol.equals(symbol);
    }
}
