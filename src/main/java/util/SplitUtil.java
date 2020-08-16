package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {
    private SplitUtil() {
    }

    public static List<Integer> splitToNumber(String target, String delimiter) {
        return Arrays.stream(target.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
