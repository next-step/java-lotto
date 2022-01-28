package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {

    public String extractCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
        }
        return customDelimiter;
    }
}
