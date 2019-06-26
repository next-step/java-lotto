package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtil {
    public static String[] split(String inputWinningNumbers) {
        return inputWinningNumbers.trim().split("\\s*" + "," + "\\s*");
    }

    public static List<Integer> convertIntList(String[] strings) {
        return Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList());

    }
}
