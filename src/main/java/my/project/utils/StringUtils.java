package my.project.utils;

/**
 * Created : 2020-11-20 오전 11:55
 * Developer : Seo
 */
public class StringUtils {

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    private StringUtils() {
    }
}
