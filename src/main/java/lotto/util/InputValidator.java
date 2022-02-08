package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator extends Validator {

    private InputValidator() {
        super();
    }

    public static List<Integer> validate(String input) {
        return Arrays.stream(input.split(","))
            .map(number -> parseToInt(number.trim()))
            .collect(Collectors.toList());
    }
}
