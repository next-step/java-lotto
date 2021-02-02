package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {
        String[] inputs;
        int res = 0;
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }
        inputs = splitByCondition(text);
        for (String input : inputs) {
            InputValidator.checkIsInvalidInput(input);
            res += Integer.parseInt(input);
        }
        return res;
    }

    private String[] splitByCondition(String text) {
        String[] inputs = splitByDelimiter(text);
        if (checkCustomDelimiter(text)) {
            inputs = splitByCustomDelimiter(text);
        }
        return inputs;
    }

    private String[] splitByDelimiter(String text) {
        return text.split(",|:");
    }

    private boolean checkCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        return m.find();
    }

    private String[] splitByCustomDelimiter(String text) {
        String[] tokens = new String[]{};
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        }
        return tokens;
    }
}
