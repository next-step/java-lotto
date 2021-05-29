package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {
    private static final String SPLIT_REGEX = ",";

    public static List<Integer> convertStringToList(String data) {
        return Arrays.stream(data.split(SPLIT_REGEX))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
