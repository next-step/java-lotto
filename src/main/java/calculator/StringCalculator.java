package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String SPLIT_REG_EXP = " ";
    public void isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> split(String input) {
        return Arrays.asList(input.split(SPLIT_REG_EXP));
    }
}
