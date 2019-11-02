package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String ZERO = "0";
    private String input;

    public StringAddCalculator() {
        this(null);
    }

    public StringAddCalculator(String input) {
        this.input = input;
    }

    public int add(String input) {
        try {
            input = validate(input);
        } catch (NullPointerException e) {
            return Integer.parseInt(ZERO);
        }

        String[] numbers = numberSplit(input);
        return sum(numbers);
    }

    public int sum(String[] inputs) {
        int sum = 0;
        for (String input : inputs) {
            sum += Integer.parseInt(input);
        }
        return sum;
    }

    public String[] numberSplit(String input) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            return tokens;
        }

        return input.split("[,:]");
    }

    private String validate(String input) {
        if (input.isEmpty()) {
            return ZERO;
        }
        return nullValidate(input);
    }

    private String nullValidate(String input) {
        try {
            return input;
        } catch (NullPointerException e) {
            return ZERO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAddCalculator that = (StringAddCalculator) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
