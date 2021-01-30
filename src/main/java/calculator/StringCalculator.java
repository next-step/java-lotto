package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add (String text) {
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }

        if(checkCustomDelimiter(text)) {
            return splitByCustomDelimiter(text);
        }
        return splitByDelimiter(text);
    }

    private boolean checkCustomDelimiter(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        return m.find();
    }
    
    private int splitByDelimiter (String text) {
        String [] inputs = text.split(",|:");
        int res = 0;
        for (String input : inputs) {
            if (InputValidator.checkIsInvalidInput(input)) {
                throw new RuntimeException();
            }
            res += Integer.parseInt(input);
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
                res += Integer.parseInt(input);
            }
            return res;
        }
        return 0;
    }

}
