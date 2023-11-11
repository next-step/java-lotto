package lotto.step1.calculator;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS(
            "+",
            (num1, num2) -> String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2))
    ),
    MINUS(
            "-",
            (num1, num2) -> String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2))
    ),
    MULTIPLY(
            "*",
            (num1, num2) -> String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2))
    ),
    DIVIDE(
            "/",
            (num1, num2) -> String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2))
    );

    private final String symbol;
    private final BinaryOperator<String> calculator;

    Operator(final String symbol, final BinaryOperator<String> calculator) {
        this.symbol = symbol;
        this.calculator = calculator;
    }

    public String calculate(final String num1, final String num2) {
        return calculator.apply(num1, num2);
    }

    public static Operator findBySymbol(final String symbol) {
        Operator findedOperator = findOperatorWithMatchingSymbol(symbol);

        throwExceptionIfOperatorIsNull(findedOperator, symbol);

        return findedOperator;
    }

    private static Operator findOperatorWithMatchingSymbol(final String symbol) {
        Operator result = null;

        for (final Operator operator : values()) {
            result = compareSymbolAndAssignResultIfMatched(result, operator, symbol);
        }

        return result;
    }

    private static Operator compareSymbolAndAssignResultIfMatched(final Operator result, final Operator operator, final String symbol) {
        if (result != null) {
            return result;
        }

        if (operator.isSameOperator(symbol)) {
            return operator;
        }

        return null;
    }

    private static void throwExceptionIfOperatorIsNull(final Operator result, final String symbol) {
        if (result == null) {
            throw new IllegalArgumentException(symbol + " is not supported");
        }
    }

    private boolean isSameOperator(final String symbol) {
        return this.symbol.equals(symbol);
    }
}
