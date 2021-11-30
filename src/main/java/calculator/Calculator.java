package calculator;

import java.util.Arrays;

public class Calculator {
    public static int compute(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] strings = s.split(",|:");
        return Arrays.stream(strings).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
    }
}
