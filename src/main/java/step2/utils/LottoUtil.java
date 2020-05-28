package step2.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {

    private static final String DELIMITER = ",";

    public static List<Integer> convertTo(String s) {
        return Arrays.stream(s.split(DELIMITER))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }
}
