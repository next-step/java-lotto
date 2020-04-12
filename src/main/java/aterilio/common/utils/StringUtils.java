package aterilio.common.utils;

public final class StringUtils {

    private StringUtils() { }

    public static boolean isNullOrEmpty(final String text) {

        if ( text == null ) {
            return true;
        }

        if ( text.isEmpty() ) {
            return true;
        }

        if ( text.trim().isEmpty() ) {
            return true;
        }

        return false;
    }

    public static boolean isNumeric(final String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Throwable e) {
            return false;
        }
    }
    public static String serialize(final Object[] arrays) {
        return serialize(arrays, ',');
    }

    public static String serialize(final Object[] arrays, final char token) {
        StringBuilder sb = new StringBuilder();
        for (Object text : arrays) {
            sb.append(text).append(token);
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
