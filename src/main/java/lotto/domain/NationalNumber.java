package lotto.domain;

import lotto.exception.InvalidInputException;

import java.util.regex.Pattern;

public class NationalNumber {
    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final String INVALID_STRING_MESSAGE = "숫자만 입력 가능합니다.";

    public static void validateStrNumber(String strNumber) {
        if (!Pattern.compile(NUMBER_REG_EXP).matcher(strNumber).find()) {
            throw new InvalidInputException(INVALID_STRING_MESSAGE);
        }
    }
}
