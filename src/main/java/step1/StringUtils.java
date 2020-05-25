package step1;

public class StringUtils {

    public static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
