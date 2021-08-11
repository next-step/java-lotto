package lotto.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberParser {

    private static final String DEFAULT_SEPARATOR = ",";

    public List<Integer> parseToWinningNumbers(String elements) {
        return Arrays.stream(elements.split(DEFAULT_SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
