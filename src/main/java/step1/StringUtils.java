package step1;

public class StringUtils {

    private StringUtils() {

    }

    public static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return text.trim().isEmpty();
    }

}
