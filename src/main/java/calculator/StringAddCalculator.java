package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private final List<String> delimiters;
    private final List<Integer> numbers = new ArrayList<>();
    private Pattern customPattern = Pattern.compile("//(.)\n(.*)");

    public StringAddCalculator(final String inputString) {
        delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        if (stringValidater(inputString)) {
            String target = setCustomDelimiter(inputString);
            setNumbers(target.split(getStringifyDelimiter()));
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
        Matcher delimiterMatcher = customPattern.matcher(str);

        if (delimiterMatcher.find()) {
            String customDelimiter = delimiterMatcher.group(1);
            delimiters.add(customDelimiter);
            return delimiterMatcher.group(2);
        }

        return str;
    }
}
