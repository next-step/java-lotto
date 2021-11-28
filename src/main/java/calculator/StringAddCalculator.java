package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        NumberTokens numbers = new NumberTokens(text);
        return addStringArray(numbers.getTokens());
    }

    private static int addStringArray(String[] tokens){
        return Arrays.stream(tokens)
                        .mapToInt(number -> Integer.parseInt(number))
                        .sum();
    }
}
