package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListIntegerConverter {
    private static final String SPLITTER = ",";

    public static List<Integer> convert(String numbers) {
        return Arrays.stream(numbers.split(SPLITTER))
                .map(str -> Integer.parseInt(str.trim()))
                .collect(Collectors.toList());
    }
}
