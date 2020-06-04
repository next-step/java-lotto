package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    private StringUtil() {
    }

    public static List<Integer> splitAndToIntegerList(String inputString) {
        return Arrays.stream(inputString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
