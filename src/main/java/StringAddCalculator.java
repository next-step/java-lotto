import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static List<String> extractStringNumber(String input) {
        return Arrays.asList(splitByDefault(input));
    }

    private static String[] splitByDefault(String input) {
        return input.split(",|:");
    }
}
