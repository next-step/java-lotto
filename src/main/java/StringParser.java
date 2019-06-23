import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> parseByDelimiter(String input) {
        return Arrays.asList(input.split(",|:"));
    }
}
