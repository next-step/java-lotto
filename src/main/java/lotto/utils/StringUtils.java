package lotto.utils;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final String DEFAULT_SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String DELETE_BLANK = "";

    private StringUtils() {
    }

    public static List<String> splitString(String value) {
        valid(value);
        return Arrays.asList(deleteBlank(value).split(DEFAULT_SEPARATOR));
    }

    private static void valid(String value) {
        if (value == null || value.isEmpty() || value.equals(" ")) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }
    }

    private static String deleteBlank(String value) {
        return value.replaceAll(BLANK, DELETE_BLANK);
    }
}
