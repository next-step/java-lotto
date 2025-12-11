package lottogame.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class StringUtils {

    public static Set<Integer> splitAndParseToInt(String rawValue, String delimiter) {
        Set<Integer> inputLottoNums = Arrays.stream(rawValue.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        return inputLottoNums;
    }
}
