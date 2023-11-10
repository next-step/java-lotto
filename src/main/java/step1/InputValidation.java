package step1;

import java.util.Arrays;
import java.util.List;

public class InputValidation {

    private static final List<String> OPERATION_SYMBOLS = Arrays.asList("+", "-", "*" , "/");

    public void validate(String[] numAndSymbols) {
        for (int idx = 0; idx < numAndSymbols.length; idx++) {
            validateNone(numAndSymbols[idx]);
            validateNumAndSymbol(numAndSymbols[idx], idx);
        }
    }

    private void validateNone(String numAndSymbol) {
        if (isNone(numAndSymbol)) {
            throw new IllegalArgumentException("숫자, 연산 기호 자리에는 공백이 입력될 수 없습니다.");
        }
    }

    private boolean isNone(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private void validateNumAndSymbol(String numAndSymbol, int idx) {
        if (isNumber(idx)) {
            validateParseToDouble(numAndSymbol);
            return;
        }

        validateOperationSymbols(numAndSymbol);
    }

    private boolean isNumber(int idx) {
        return idx % 2 == 0;
    }

    private void validateParseToDouble(String number) {
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자 자리에는 실수만 입력 가능합니다.");
        }
    }

    private void validateOperationSymbols(String symbol) {
        if (OPERATION_SYMBOLS.contains(symbol)) {
            return;
        }

        throw new IllegalArgumentException("연산기호는 (+, -, *, /)만 가능합니다.");
    }
}
