package lotto.utils;

import lotto.model.Lotto;
import lotto.model.Number;

import java.util.Arrays;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class StringUtils {

    public static final String SEPARATOR_OF_LOTTO_NUMBERS = ",";

    public static Lotto parseLotto(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR_OF_LOTTO_NUMBERS))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(collectingAndThen(toList(), Lotto::from));
    }
}
