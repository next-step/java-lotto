package calculator;

import java.util.Objects;
import java.util.Set;

public enum InputItemType {
    NUMBER, OPERATOR, SPACE, UNKNOWN;

    public static final Set<String> OPERATORS = java.util.Set.of("+", "-", "*", "/");

    public static InputItemType from(String inputItem) {
        if (isNumber(inputItem)) {
            return InputItemType.NUMBER;
        }

        if (isOperator(inputItem)) {
            return InputItemType.OPERATOR;
        }

        if (isSpace(inputItem)) {
            return InputItemType.SPACE;
        }

        return UNKNOWN;
    }

    public boolean isNumber() {
        return this == NUMBER;
    }

    public boolean isOperator() {
        return this == OPERATOR;
    }

    public boolean isSpace() {
        return this == SPACE;
    }

    private static boolean isNumber(String item) {
        return item.matches("-?\\d+");
    }

    public static boolean isOperator(String item) {
        return OPERATORS.contains(item);
    }

    private static boolean isSpace(String item) {
        return Objects.equals(item, " ");
    }
}
