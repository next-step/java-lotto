package domain;

import java.util.Arrays;
import java.util.List;

public enum Operator {

    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    public static final String IS_NOT_SYMBOL_ERROR_MESSAGE = "계산부호가 아닌 값이 입력되었습니다.";
    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }


    public static void validateOperatorSymbol(List<String> operators) {
        operators.stream()
                .forEach(Operator::validateOperatorSymbol);
    }

    private static void validateOperatorSymbol(String mark) {
        Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(mark))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(IS_NOT_SYMBOL_ERROR_MESSAGE));
    }

    public String getSymbol() {
        return symbol;
    }
}
