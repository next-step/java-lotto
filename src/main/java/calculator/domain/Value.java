package calculator.domain;

import util.CommonException;
import util.Message;

public class Value {
    private static final int ZERO = 0;
    private int number;

    public int getNumber() {
        return number;
    }

    public Value() {
    }

    public Value(String value) {
        validateValue(value);
    }

    public void validateNullAndEmpty(String inputValue) {
        if(inputValue == null || inputValue.isEmpty()) {
            this.number = ZERO;
        }
    }

    public void validateValue(String inputValue) {
        validateNullAndEmpty(inputValue);
        validateParseInt(inputValue);
        validatePositiveNumber();
    }

    private void validatePositiveNumber() {
        if(number < ZERO) {
            CommonException.RuntimeException(Message.VALIDATE_INPUT_VALUE);
        }
    }

    private void validateParseInt(String inputValue) {
        try {
            number = parseIntToString(inputValue);
        } catch (RuntimeException runtimeException) {
            CommonException.RuntimeException(Message.VALIDATE_INPUT_VALUE);
        }
    }

    private int parseIntToString(String inputValue) {
        return Integer.parseInt(inputValue);
    }
}
