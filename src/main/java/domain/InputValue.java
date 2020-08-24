package domain;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValue {
    public static int inputValueValidate(String inputValue) {
        if(inputValue == null)
            return 0;
        if(inputValue.isEmpty())
            return 0;
        if(inputValue.startsWith("//"))
            return sum(checkCustomDelimiter(inputValue));

        String[] numbers = inputValue.split(",|:");
        return sum(numbers);
    }

    public static String[] checkCustomDelimiter(String inputValue) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputValue);
        if(m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return new String[0];
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
    }

}
