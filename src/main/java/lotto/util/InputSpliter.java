package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSpliter {

    private InputSpliter() {

    }

    public static List<Integer> split(final String winnings) {
        List<String> split = Arrays.asList(winnings.split(","));
        return split.stream()
            .map(token -> Integer.parseInt(token.trim()))
            .collect(Collectors.toList());
    }
}
