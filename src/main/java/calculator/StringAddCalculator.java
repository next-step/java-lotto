package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final List<String> delimiters;
    private final List<Integer> numbers = new ArrayList<>();

    public StringAddCalculator(String str) {
        delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        if (stringValidater(str)) {
            str = setCustomDelimiter(str);
            setNumbers(str.split(getStringifyDelimiter()));
        }
    }

    private void setNumbers(String[] splitNumbers) {
        for (String number : splitNumbers) {
            numberValidator(number);
            numbers.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getSum() {
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

    private void numberValidator(String str) {
        List<String> possibleNumberList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9",
            "0");

        if (!possibleNumberList.contains(str)) {
            throw new RuntimeException();
        }
    }

    private boolean stringValidater(String str) {
        return str != null && !str.equals("");
    }

    private String getStringifyDelimiter() {
        return String.join("|", delimiters);
    }

    private String setCustomDelimiter(String str) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);

        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiters.add(customDelimiter);
            return m.group(2);
        }

        return str;
    }
}
