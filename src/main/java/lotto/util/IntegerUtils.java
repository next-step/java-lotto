package lotto.util;

public class IntegerUtils {

    public static int parsePositiveInt(String numberString) {
        if (numberString == null || numberString.trim().isEmpty()) {
            throw new NumberFormatException("``price` is must not be null or empty");
        }
        int number;
        try {
            number = Integer.parseInt(numberString.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("``value` is must be number string");
        }
        if (number < 0) {
            throw new NumberFormatException("``value` is must be positive number");
        }
        return number;
    }
}
