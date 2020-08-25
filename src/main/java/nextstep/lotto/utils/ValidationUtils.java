package nextstep.lotto.utils;

public class ValidationUtils {

    private static final String EMPTY_STRING = "";

    private ValidationUtils() {
    }

    public static boolean isNullAndEmpty(String inputValue) {
        if (inputValue == null) {
            return true;
        }

        return inputValue.trim().equals(EMPTY_STRING);
    }

}
