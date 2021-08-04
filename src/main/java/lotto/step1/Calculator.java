package lotto.step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private String text;
    private Validation validation;
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private Matcher matcher;

    public Calculator(String text) {
        this.text = text;
        this.matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(this.text);
        this.validation = new Validation(text);
    }

    public int calculate() {
        if (validation.checkEmptyAndNull()) {
            return 0;
        }

        if (validation.checkOnlyNumber()) {
            return printNumber();
        }

        if (validation.checkCustomDelimiter()) {
            text = matcher.group(2);
            String delimiter = DELIMITER + "|" + matcher.group(1);
            return addNumbers(delimiter);
        }

        return addNumbers(DELIMITER);
    }

    public void isNegativeNumber(String number) {
        if (Integer.valueOf(number) < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    public int printNumber() {
        return Integer.valueOf(text);
    }

    public int addNumbers(String delimiter) {
        String[] numbers = text.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            isNegativeNumber(number);
            sum += Integer.valueOf(number);
        }

        return sum;
    }

}
