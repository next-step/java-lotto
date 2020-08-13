package util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {
    public static List<Integer> splitToNumber(String target, String delimeter) {
        return Arrays.stream(target.split(delimeter))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
    }
}
