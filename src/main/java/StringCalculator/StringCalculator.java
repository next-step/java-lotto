package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private List<String> splitText(final String text) {
        return Arrays.asList(customSpliter(text));
    }

    public int add(final String text) {
        String newText = isEmptyText(text);
        List<String> splitText = splitText(newText);
        int result = 0;

        for (String number : splitText) {
            result += Integer.parseInt(number);
        }

        return result;
    }


    public boolean notNumber(final String text) {
        return !text.matches(".*[0-9]*");
    }

    public boolean isNegative(final String text) {
        if (text.contains("-")) {
            return true;
        }
        return false;
    }

    public String isEmptyText(final String text) {
        if (text == null || text.length() == 0) {
            return "0";
        }
        if (isNegative(text)) {
            throw new RuntimeException("음수는 불가능합니다");
        }
        return text;
    }

    private String[] customSpliter(final String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }
        if(notNumber(text)){
            throw new RuntimeException("숫자가 아닙니다");
        }
        return text.split(",|:");
    }
}
