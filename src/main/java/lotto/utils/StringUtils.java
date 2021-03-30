package lotto.utils;


import lotto.Constant;

public class StringUtils {
    private static final String STRING_SPLIT_PATTEN = ",";

    public static String[] getStringToStringArray(String number) {
        return number.split(STRING_SPLIT_PATTEN);
    }

    public static String getNumToString(int num) {
        try {
            return String.valueOf(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(Constant.ERROR_NULL_MSG);
        }
    }
}
