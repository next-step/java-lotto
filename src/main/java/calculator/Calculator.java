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
        StringNumber stringNumber = new StringNumber(numbers);
        return sumNum(stringNumber);
    }

    private int sumNum(StringNumber number) {
        return number.sumNum();
    }
}
