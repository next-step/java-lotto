package lotto.util;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public final class StringUtils {

    public StringUtils() {
        throw new AssertionError("no instance available");
    }

    public static Set<Integer> refineNumbers(String text) {
        return Arrays.stream(splitStringToLottoNumbers(removeSpace(text)))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static String[] splitStringToLottoNumbers(String winningNumbersNoSpace) {
        return winningNumbersNoSpace.split(",");
    }

    public static String removeSpace(String winningLottoNumbers) {
        return winningLottoNumbers.replace(" ", "");
    }

}
