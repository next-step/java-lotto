package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String text;
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);

    public Calculator(String text) {
        this.text = text;
    }

    public boolean checkEmptyAndNull() {
        if (text.equals("") || text.equals(" ") || text.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean checkNotNegativeNumber() {
        String[] numbers = text.split(DELIMITER);
        for (String number : numbers) {
            isNegativeNumber(number);
        }
        return true;
    }

    public void isNegativeNumber(String number) {
        if (Integer.valueOf(number) < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }

    }

    public int printNumber() {
        return Integer.valueOf(text);
    }

    public int calculate() {
        if (checkCustomDelimiter()) {
           return addNumbers(matcher.group(1));
        }

       return addNumbers(DELIMITER);
    }
    public boolean checkCustomDelimiter() {
        return matcher.find();
    }

    public int addNumbers(String delimiter) {
        String[] numbers = text.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.valueOf(number);
        }

        return sum;
    }

}
