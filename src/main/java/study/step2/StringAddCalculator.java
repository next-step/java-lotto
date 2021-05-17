package study.step2;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        return sum(text.split("[,:]"));
    }

    private static int sum(String ...number) {
        return Arrays.stream(number)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
