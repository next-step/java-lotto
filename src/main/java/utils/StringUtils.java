package utils;

public class StringUtils {
    public static String[] splitWith(String source, String regExpDelimiter) {
        if(source == null){
            return null;
        }
        return source.split(regExpDelimiter);
    }

    public static boolean isEmpty(String source) {
        return source == null || source.trim().length() <= 0;
    }
}
