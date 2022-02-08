package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    protected Validator() {
    }

    public static List<Integer> splitInput(String input) {
        return Arrays.stream(input.split(","))
            .map(number -> parseToInt(number.trim()))
            .collect(Collectors.toList());
    }

    static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }
}
