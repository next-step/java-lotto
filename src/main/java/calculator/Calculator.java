package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static int calculate(String s) {
        int result = 0;
        return result;
    }

    public static List<Object> toIntArray(String s) {
        String[] spliitedString = s.split(" ");
        return processEachLetter(spliitedString);
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
}
