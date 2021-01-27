package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add (String text) {
        int res = 0;
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }

        if (isOneNumber(text) && InputValidator.checkInvalidInput(text)) {
            return Integer.parseInt(text);
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
    
    private int abc (String text) {
        String [] inputs = text.split(",|:");
        int res = 0;
        for (String input : inputs) {
            if (!InputValidator.checkInvalidInput(input)) {
                throw new RuntimeException();
            }
            res += Integer.parseInt(input);
        }
        return res;
    }

    private int splitByDelimiter(String text) {
        // throw 된 exception 을 처리하는 곳은 어디에?
        String [] inputs = text.split(",|:");
        int res = Arrays.stream(inputs)
                //.map(InputValidator::isNegative)
                .filter(input -> InputValidator.checkInvalidInput(input))
                .map(Integer::parseInt)
                .reduce(Integer::sum).get();
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
