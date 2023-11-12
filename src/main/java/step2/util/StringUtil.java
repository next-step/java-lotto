package step2.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {

    private static final String DELIMITER = ", ";

    public static List<Integer> numbers(String text) {
        return Arrays.stream(text.split(DELIMITER))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

}
