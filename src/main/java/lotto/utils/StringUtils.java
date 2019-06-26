package lotto.utils;

import lotto.model.Number;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringUtils {

    public static final String LOTTO_NUMBERS_SEPARATOR = ",";

    public static List<Number> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(LOTTO_NUMBERS_SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(toList());
    }
}
