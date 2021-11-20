package calculator;

import java.util.Arrays;

public class StringAddCalculator {
    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String regex = ",|:";
        if (text.contains("//") && text.contains("\n")) {
            int startIdx = text.indexOf("//") + 2;
            int endIdx = text.indexOf("\n");
            regex = regex + "|" + text.substring(startIdx, endIdx);
            text = text.substring(endIdx + 1);
        }

        String[] split = text.split(regex);

        if (Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .filter(num -> num < 0)
                .findAny()
                .isPresent()) {
            throw new RuntimeException();
        };

        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }
}
