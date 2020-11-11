package lotto.lib;

import lotto.exception.NanException;
import lotto.exception.NpeException;

import java.util.Optional;

public class GeneralValidator {
    private GeneralValidator() {}

    protected static boolean checkNan(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    protected static void validateNpe(String nullable) {
        Optional.ofNullable(nullable).orElseThrow(NpeException::getInstance);
    }

    protected static void validateNan(String number) {
        if (checkNan(number)) {
            throw NanException.getInstance();
        }
    }

    protected static void validateStrNum(String strNum) {
        validateNpe(strNum);
        validateNan(strNum);
    }
}
