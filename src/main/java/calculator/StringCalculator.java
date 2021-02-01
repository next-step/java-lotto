package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add (String text) {
        int res = 0;
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }

        if(checkCustomDelimiter(text)) {
            return splitByCustomDelimiter(text);
        }
        return splitByDelimiter(text);
    }

    private boolean isOneNumber(String text) {
        String [] inputs = text.split(",|:");
        if (inputs.length == 1) {
            return true;
        }
        return false;
    }

    private boolean checkCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return true;
        }
        return false;
    }
    
    private int splitByDelimiter (String text) {
        String [] inputs = text.split(",|:");
        int res = 0;
        for (String input : inputs) {
            res += InputValidator.validatedInput(input);
        }
        return res;
    }

    private int splitByCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            int res = 0;
            for (String input : tokens) {
                res += InputValidator.validatedInput(input);
            }
            return res;
        }
        return 0;
    }

}
