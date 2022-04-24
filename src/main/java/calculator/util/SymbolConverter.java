package calculator.util;

import calculator.util.Operator.Symbol;

import java.util.Objects;

public class SymbolConverter {

    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public static Symbol convert(String operator) {
        if (Objects.equals(operator, SUBTRACTION)) {
            return Symbol.SUBTRACTION;
        }

        if (Objects.equals(operator, MULTIPLICATION)) {
            return Symbol.MULTIPLICATION;
        }

        if (Objects.equals(operator, DIVISION)) {
            return Symbol.DIVISION;
        }

        return Symbol.ADDITION;
    }
}
