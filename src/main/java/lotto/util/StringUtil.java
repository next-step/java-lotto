package lotto.util;

public class StringUtil {
    public static String[] split(String delimiter, String inputString) {
        if (isIllegalArgument(inputString)) {
            throw new IllegalArgumentException();
        }
        return inputString.replace(" ", "")
                .split(delimiter);
    }

    private static boolean isIllegalArgument(String inputString) {
        return inputString == null || "".equals(inputString.trim()) ? true : false;
    }
}
