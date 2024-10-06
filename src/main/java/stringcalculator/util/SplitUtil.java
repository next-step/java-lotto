package stringcalculator.util;

import java.util.Arrays;
import java.util.List;

public class SplitUtil {

    public static final String SPACE = " ";

    public static List<String> split(String input) {
        return Arrays.asList(input.split(SPACE));
    }
}
