package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerUtil {

    private IntegerUtil() {
    }

    public static List<Integer> parseInt(String[] strings) {
        return Arrays.stream(strings)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
