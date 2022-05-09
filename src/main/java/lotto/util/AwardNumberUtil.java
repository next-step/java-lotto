package lotto.util;

import lotto.enums.Grade;
import lotto.exception.BonusContainWinningResultException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class AwardNumberUtil {


    private AwardNumberUtil() {
    }

    private static final String DELIMITER = ", ";

    public static Set<Integer> getAwardNumberList(String numbers) {
        return Arrays.stream(split(numbers))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }


    private static String[] split(String string) {
        return string.split(DELIMITER);
    }

}
