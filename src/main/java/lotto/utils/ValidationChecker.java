package lotto.utils;

import java.util.List;

public class ValidationChecker {
    private static final int ZERO = 0;

    private ValidationChecker() {
    }

    public static void isEmptyOrNull(String inputValue) {
         if(inputValue == null || inputValue.isEmpty()) {
             throw new RuntimeException("값을 입력해 주세요!");
         }
    }

    public static boolean exceptionCheck(String inputValue) {
        checkChar(inputValue);
        checkNegative(inputValue);
        return true;
    }

    private static void checkNegative(String negative) {
        if(Integer.parseInt(negative) < ZERO) {
            throw new RuntimeException("음수가 입력되었습니다.");
        }
    }

    private static void checkChar(String character) {
        try {
            Integer.parseInt(character);
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("문자가 입력되었습니다.");
        }
    }
}
