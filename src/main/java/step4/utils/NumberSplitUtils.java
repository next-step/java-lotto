package step4.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSplitUtils {

    public static List<Integer> splitWinNumberString(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }
}
