package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public final class StringConverter {

    public static final String DELIMITER = ",";

    public static List<Integer> convertTo(String s) {
        return Arrays.stream(s.split(DELIMITER))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }
}
