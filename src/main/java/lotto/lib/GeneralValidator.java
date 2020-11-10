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

    protected static void validateStrNum(String strNum) {
        Optional.ofNullable(strNum).orElseThrow(NpeException::getInstance);
        if (checkNan(strNum)) {
            throw NanException.getInstance();
        }
    }
}
