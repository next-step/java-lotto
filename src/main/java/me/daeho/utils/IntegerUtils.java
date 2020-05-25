package me.daeho.utils;

public class IntegerUtils {
    private static final String BLANK = "";
    public static boolean isEmpty(String data) {
        return data == null || BLANK.equals(data.trim());
    }

    public static boolean isOnlyNumber(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
