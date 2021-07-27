package calculator;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {
    private static final String SPLIT_KEYWORD = ",";
    public static int splitAndSum(String input) {
        List<String> inputs = Arrays.asList(input.split(SPLIT_KEYWORD));
        return inputs.stream().mapToInt(Integer::parseInt).sum();
    }
}
