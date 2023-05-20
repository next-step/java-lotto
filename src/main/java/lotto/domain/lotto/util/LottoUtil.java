package lotto.domain.lotto.util;

import lotto.domain.lotto.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {

    private static final String SPLIT_DELIMITER = ",";

//    public static List<Integer> answerToIntegers(String stringNumbers) {
//        return Arrays.stream(splitNumbers(stringNumbers))
//                .map(stringNumber -> Integer.parseInt(stringNumber.trim()))
//                .collect(Collectors.toList());
//    }
    public static Lotto stringsToLotto(String stringNumbers) {
        List<Integer> integers = Arrays.stream(splitNumbers(stringNumbers))
                .map(stringNumber -> Integer.parseInt(stringNumber.trim()))
                .collect(Collectors.toList());

        return new Lotto(integers);
    }

    private static String[] splitNumbers(String numbers) {
        return numbers.trim().split(SPLIT_DELIMITER);
    }
}
