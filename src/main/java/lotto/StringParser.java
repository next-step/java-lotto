package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {
    public static List<Integer> parseIntList(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());
    }
}
