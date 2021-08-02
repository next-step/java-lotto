package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String text;
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

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
        int sum = 0;
        String[] numbers = text.split(DELIMITER);
        for (String number : numbers) {
            sum += Integer.valueOf(number);
        }
        return sum;
    }

    public void CustomDelimiter() {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            matcher.group(2).split(customDelimiter);
        }

    }
//    public boolean CustomDelimiter2() {
//        return Pattern.compile(CUSTOM_DELIMITER).matcher(text);
//    }
}
