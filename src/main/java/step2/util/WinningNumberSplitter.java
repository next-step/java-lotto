package step2.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningNumberSplitter {

    private static final Pattern NUMBER_SPLIT_PATTERN = Pattern.compile("\\s*,\\s*");

    public static List<Integer> split(String winningNumber) {
        return Arrays.stream(NUMBER_SPLIT_PATTERN.split(winningNumber))
                .map(WinningNumberSplitter::parseInt)
                .collect(Collectors.toList());
    }

    private static int parseInt(String i) {
        try {
            return Integer.parseInt(i);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("당첨 번호는 숫자만 입력 가능합니다.");
        }
    }
}
