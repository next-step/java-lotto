package lotto.utils;

import lotto.domain.Ball;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtils {

    private static final String SPLIT_DELIMITER = ",";

    public static Set<Ball> generateStringToBalls(String inputLottoNumberString) {
        return Arrays.stream(inputLottoNumberString.split(SPLIT_DELIMITER))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .map(Ball::from)
                .collect(Collectors.toSet());
    }
}
