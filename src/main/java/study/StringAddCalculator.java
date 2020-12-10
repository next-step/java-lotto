package study;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    public static int splitAndSum(String string) {
        if (isNull(string) || isEmpty(string)) {
            return 0;
        }
        return stringsSum(split(string));
    }

    private static boolean isEmpty(String string) {
        return string.isEmpty();
    }

    private static boolean isNull(String string) {
        return string == null;
    }

    private static List<String> split(String string) {
        return Arrays.asList(string.split("[,:]"));
    }

    private static int stringsSum(List<String> strings) {
        return strings.stream()
                .mapToInt(Integer::parseInt).sum();
    }
}
