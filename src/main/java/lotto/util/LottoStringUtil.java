package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStringUtil {

    private LottoStringUtil() {
    }

    public static List<Integer> splitStringToIntegerList(String numberString) {
        return Arrays.stream(numberString.split(","))
                     .map(String::trim)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

}
