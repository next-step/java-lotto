package StringCalculator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputParser {

    public static List<String> parseStringToStringList(String input) {
        if (input == null || "".equals(input)) {
            return Collections.singletonList("0");
        }
        return Arrays.asList(input.split("[,:]"));
    }
}
