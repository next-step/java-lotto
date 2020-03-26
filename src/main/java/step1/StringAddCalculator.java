package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static step1.Numbers.INIT_VALUE;

public class StringAddCalculator {
    public static int calculate(String input) {
        if(InputChecker.isNullOrEmpty(input)) {
            return INIT_VALUE;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);

        String[] strings;

        if (m.find()) {
            String customDelimiter = m.group(1);
            strings= m.group(2).split(customDelimiter);
            // 덧셈 구현
        }
        else {
            strings = input.split(",|:");
        }
        Numbers numbers = new Numbers(strings);

        return numbers.addAll();
    }
}
