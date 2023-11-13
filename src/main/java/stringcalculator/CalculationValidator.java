package stringcalculator;

public class CalculationValidator {

    public static void validate(String[] numAndSymbols) {
        for (int idx = 0; idx < numAndSymbols.length; idx++) {
            validateNone(numAndSymbols[idx]);
            validateNumAndSymbol(numAndSymbols[idx], idx);
        }
    }

    private static void validateNone(String numAndSymbol) {
        if (isNone(numAndSymbol)) {
            throw new IllegalArgumentException("숫자, 연산 기호 자리에는 공백이 입력될 수 없습니다.");
        }
    }

    private static boolean isNone(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private static void validateNumAndSymbol(String numAndSymbol, int idx) {
        if (isNumberPosition(idx)) {
            validateParseToDouble(numAndSymbol);
            return;
        }

        validateOperationSymbols(numAndSymbol);
    }

    private static boolean isNumberPosition(int idx) {
        return idx % 2 == 0;
    }

    private static void validateParseToDouble(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 자리에는 실수만 입력 가능합니다.");
        }
    }

    private static void validateOperationSymbols(String symbol) {
        if (OperationSymbols.isOperationSymbol(symbol)) {
            return;
        }

        throw new IllegalArgumentException("연산기호는 (+, -, *, /)만 가능합니다.");
    }
}