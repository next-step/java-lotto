import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {
    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static List<String> splitByDefault(String input) {
        return Arrays.asList(input.split(",|:"));
    }
}
