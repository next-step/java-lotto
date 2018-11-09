package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int getSum(String text) {
        return getSumNumber(StringMatch(text));
    }

    private String[] StringMatch(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }
        return text.split(",|:");
    }

    private int getSumNumber(String[] numbers) {
        int sumNumber = 0;
        for (String number : numbers) {
            sumNumber += isNumber(number);
        }
        return sumNumber;
    }

    private int isNumber(String number) {
        int isNumber = Integer.parseInt(number);
        if(isNumber < 0){
            new RuntimeException();
        }
        return isNumber;
    }
}
