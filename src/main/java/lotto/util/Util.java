package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    public static List<Integer> stringToIntegerList(String unrefinedNumber) {
        return Arrays.asList(unrefinedNumber.split(", ")).stream().map(Integer::parseInt).collect(
            Collectors.toList());
    }
}
