package my.project.utils;

import my.project.messages.ExceptionMessages;

public class IntUtils {
    public static void isQualified(Integer number) {
        if (number < 1) {
            throw new IllegalArgumentException(ExceptionMessages.INPUT_HAS_NEGATIVE);
        }
    }



    private IntUtils() {
    }
}
