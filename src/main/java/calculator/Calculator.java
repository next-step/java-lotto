package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        int result = 0;
        return result;
    }

    public static List<Object> toIntArray(String input) {
        String[] splittedString = input.split(" ");
        return processEachLetter(splittedString);
    }

    private static List<Object> processEachLetter(String[] spliitedString) {
        List<Object> result = new ArrayList<>();
        Arrays.stream(spliitedString).forEach(eachWord-> {
            try {
                int num = Integer.parseInt(eachWord);
                result.add(num);
            } catch (NumberFormatException nfe) {
                result.add(eachWord);
            }
        });
        return result;
    }

    public static int addNum(int leftValue, int rightValue) {
        return leftValue+rightValue;
    }
}
