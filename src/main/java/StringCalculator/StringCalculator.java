package StringCalculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public List<String> splitText(final String text) {
        return Arrays.asList(customSpliter(text));
    }

    public boolean notNumber(final String text) {
        return !text.matches(".*[0-9]*");
    }

    public List<String> notNegative(final List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            if (Integer.parseInt(text.get(i)) < 0) {
                throw new AdderException("음수는 불가능합니다");
            }
        }
        return text;
    }

    public String isEmptyText(final String text) {
        if (text == null || text.length() == 0) {
            return "0";
        }
        return text;
    }

    private String[] customSpliter(final String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        if (notNumber(text)) {
            throw new AdderException("숫자가 아닙니다");
        }
        return text.split("[,:]");
    }
}
