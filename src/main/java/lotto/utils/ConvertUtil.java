package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertUtil {

    private final static String CHECK_CHARACTER = "%s에 문자가 포함되어 있는지 확인해주세요.";

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(CHECK_CHARACTER, input));
        }
    }

    public static List<Integer> toIntegers(List<String> input) {
        try {
            return new ArrayList<>(Collections.unmodifiableList(input.stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList())));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(CHECK_CHARACTER, input));
        }
    }
}
