package stringcalculator.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {
    public static List<String> split(String input) {
        return Arrays.asList(input.split(" "));
    }
}
