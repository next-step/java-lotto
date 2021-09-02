import java.util.regex.Pattern;

public class CalculatorApplication {
    public static void main(String[] args) {

    }

    public static boolean isNumber(String first) {
        return Pattern.matches("\\d", first);
    }

    public static String findFirstString(String[] inputStrings) {
        final String inputString = inputStrings[0];
        final char firstChar = inputString.charAt(0);
        return String.valueOf(firstChar);
    }
}
