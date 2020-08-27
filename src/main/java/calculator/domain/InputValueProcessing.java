package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValueProcessing {
    private static Pattern pattern= Pattern.compile("//(.)\n(.*)");

    public static int calculateInputValue(String inputValue) {
        if (inputValue == null)
            return 0;
        if (inputValue.isEmpty())
            return 0;
        if (inputValue.startsWith("//")) {
            return new Numbers(checkCustomDelimiter(inputValue)).sum();
        }

        return new Numbers(inputValue.split(",|:")).sum();
    }

    public static String[] checkCustomDelimiter(String inputValue) {
        Matcher m = pattern.matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return new String[0];
    }


}
