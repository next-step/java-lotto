package lotto.view;

import lotto.exception.NanException;
import lotto.exception.NpeException;

import java.util.Optional;

public class InputValidator {
    private InputValidator() {}

    static void validateNpe(String nullable) {
        Optional.ofNullable(nullable).orElseThrow(NpeException::getInstance);
    }

    static void validateNan(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw NanException.getInstance();
        }
    }

    static void validateNumber(String number) {
        validateNpe(number);
        validateNan(number);
    }
}
