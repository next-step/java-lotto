package lotto.domain;

import java.util.Arrays;

public class Parser {
    public static Integer[] parse(String[] inputStrings) {
        return Arrays.stream(inputStrings)
                .map(v -> Integer.parseInt(v))
                .toArray(Integer[]::new);
    }
}
