package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    private static final String DELIMITER = ",";
    private static final String SPACE = " ";
    private static final String NOT_SPACE = "";

    private Parser() {
    }

    public static List<Integer> splitInput(String input) {
        String[] split = input.replace(SPACE, NOT_SPACE).split(DELIMITER);

        return Arrays.stream(split).map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
