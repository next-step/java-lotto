package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {
    private static final String COMMA_DELIMITER = ",";

    private static String[] separateLineWithComma(String line) {
        return line.split(COMMA_DELIMITER);
    }

    public static List<Integer> convertTo(String line) {
        String[] separateLine = separateLineWithComma(line);
        return Arrays.stream(separateLine)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
