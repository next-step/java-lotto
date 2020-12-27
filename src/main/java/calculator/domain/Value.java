package calculator.domain;

import util.CommonException;
import util.Message;

public class Value {
    private static final int ZERO = 0;
    private int parseInt = 0;

    public int validateNullAndEmpty(String inputValue) {
        if(inputValue == null ||inputValue.isEmpty()) {
            return ZERO;
        }

        return 1;
    }

    public void validatePositiveValue(Object inputValue) {
        validateParseInt((String) inputValue);
        validatePositiveNumber();
    }

    private void validatePositiveNumber() {
        if(parseInt < ZERO) {
            CommonException.RuntimeException(Message.VALIDATE_INPUT_VALUE);
        }
    }

    private void validateParseInt(String inputValue) {
        try {
            parseInt = parseIntToString(inputValue);
        } catch (RuntimeException runtimeException) {
            CommonException.RuntimeException(Message.VALIDATE_INPUT_VALUE);
        }
    }

    private int parseIntToString(String inputValue) {
        return Integer.parseInt(inputValue);
    }
}
