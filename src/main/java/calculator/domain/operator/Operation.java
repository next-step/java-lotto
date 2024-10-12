package calculator.domain.operator;

import calculator.util.StringUtil;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

enum Operation {

    ADDITION("+", Integer::sum),

    SUBTRACTION("-", (operand1, operand2) -> operand1 - operand2),

    MULTIPLICATION("*", (operand1, operand2) -> operand1 * operand2),

    DIVISION("/", (operand1, operand2) -> {
        if (operand2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return operand1 / operand2;
    });

    private final String symbol;
    private final IntBinaryOperator function;

    Operation(String symbol, IntBinaryOperator operation) {
        this.symbol = symbol;
        this.function = operation;
    }

    static IntBinaryOperator findFunctionBySymbol(String symbol) {
        if (StringUtil.isEmpty(symbol)) {
            throw new IllegalArgumentException("기호를 입력해 주세요.");
        }
        return Arrays.stream(values())
                .filter(operation -> hasSymbol(operation, symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사용할 수 없는 연산자입니다. : " + symbol))
                .function;
    }

    static boolean hasSymbol(Operation operation, String symbol) {
        return operation.symbol.equals(symbol);
    }
}
