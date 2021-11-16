package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String input){
        if(isEmptyOrNull(input)) return 0;
        return sum(split(input));
    }

    private static String[] split(String input) {
        return StringSplitter.getSplitInput(input);
    }

    private static int sum(String[] splitInput) {
        return Arrays.stream(splitInput)
                .mapToInt(Integer::parseInt).sum();
    }

    private static boolean isEmptyOrNull(String input){
        return input == null || input.trim().isEmpty();
    }
}